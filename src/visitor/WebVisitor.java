package visitor;

import antlr.WebParser;
import antlr.WebParserBaseVisitor;
import ast.base.ASTNode;
import ast.base.BaseNode;
import ast.web.*;
import ast.web.css.*;
import ast.web.html.*;
import ast.web.jinja.*;

import java.util.*;

public class WebVisitor extends WebParserBaseVisitor<ASTNode> {
    public ASTNode visitTemplateNode(WebParser.TemplateNodeContext ctx) {
        List<ContentItemNode> contentNodes = new ArrayList<>();

        for (var child : ctx.contentItem()) {
            ASTNode node = visit(child);

            if (node instanceof ContentItemNode content) {
                contentNodes.add(content);
            }
            // ✅ هذا هو الحل
            else if (node instanceof CssStyleNode css) {
                contentNodes.add(
                        new ContentCssStyle(
                                css,
                                css.getLine(),
                                css.getColumn()
                        )
                );
            }
        }

        return new TemplateNode(
                contentNodes,
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }

    @Override
    public ASTNode visitContentJinjaBlock(WebParser.ContentJinjaBlockContext ctx) {
        ASTNode blockNode = visit(ctx.jinjaBlock());

        if (blockNode instanceof JinjaBlockNode) {
            return new ContentJinjaBlock(
                    (JinjaBlockNode) blockNode,
                    ctx.start.getLine(),
                    ctx.start.getCharPositionInLine()
            );
        }
        return null;
    }

    @Override
    public ASTNode visitContentHtmlElement(WebParser.ContentHtmlElementContext ctx) {
        ASTNode elementNode = visit(ctx.htmlElement());

        if (elementNode instanceof BaseNode) {
            return new ContentHtmlElement(
                    (BaseNode) elementNode,
                    ctx.start.getLine(),
                    ctx.start.getCharPositionInLine()
            );
        }
        return null;
    }

    @Override
    public ASTNode visitContentHtmlText(WebParser.ContentHtmlTextContext ctx) {
        return new ContentHtmlText(ctx.htmlText().getText(),
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()) {
        };
    }

    @Override
    public ASTNode visitContentJinjaExpression(WebParser.ContentJinjaExpressionContext ctx) {
        ASTNode exprNode = visit(ctx.jinjaExpression());

        if (exprNode instanceof ast.web.jinja.JinjaExpressionNode) {
            return new ContentJinjaExpression((ast.web.jinja.JinjaExpressionNode) exprNode,
                    ctx.start.getLine(),
                    ctx.start.getCharPositionInLine()) {
            };
        }

        return null;
    }

    @Override
    public ASTNode visitBlockForStartNode(WebParser.BlockForStartNodeContext ctx) {
        WebParser.ForStartContext forCtx = ctx.forStart();

        List<String> beforeIn = new ArrayList<>();
        List<String> afterIn = new ArrayList<>();
        boolean seenIn = false;

        for (var child : forCtx.children) {
            if (child.getText().equals("in")) {
                seenIn = true;
                continue;
            }

            if (child instanceof WebParser.JinjaBlockExprContext expr) {
                if (!seenIn) {
                    beforeIn.add(expr.getText());
                } else {
                    afterIn.add(expr.getText());
                }
            }
        }

        return new ForStartNode(
                String.join("", beforeIn),
                String.join("", afterIn),
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }

    @Override
    public ASTNode visitContentJinjaComment(WebParser.ContentJinjaCommentContext ctx) {
        ASTNode commentNode = visit(ctx.jinjaComment());

        if (commentNode instanceof ast.web.jinja.JinjaCommentNode) {
            return new ContentJinjaComment((ast.web.jinja.JinjaCommentNode) commentNode,
                    ctx.start.getLine(),
                    ctx.start.getCharPositionInLine()) {
            };
        }

        return null;
    }

    @Override
    public ASTNode visitHtmlElementVoid(WebParser.HtmlElementVoidContext ctx) {
        return visit(ctx.htmlVoidElement());
    }

    @Override
    public ASTNode visitVoidElementNode(WebParser.VoidElementNodeContext ctx) {
        List<BaseNode> attributes = new ArrayList<>();

        for (var attrCtx : ctx.htmlAttribute()) {
            ASTNode attrNode = visit(attrCtx);
            if (attrNode instanceof BaseNode) {
                attributes.add((BaseNode) attrNode);
            }
        }

        return new VoidElementNode(
                ctx.HTML_IDENTIFIER().getText(), // tagName
                attributes,
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        ) {
        };
    }

    @Override
    public ASTNode visitHtmlElementNormal(WebParser.HtmlElementNormalContext ctx) {
        return visit(ctx.htmlNormalElement());
    }

    @Override
    public ASTNode visitNormalElementNode(WebParser.NormalElementNodeContext ctx) {
        List<BaseNode> attributes = new ArrayList<>();
        for (var attrCtx : ctx.htmlAttribute()) {
            ASTNode attrNode = visit(attrCtx);
            if (attrNode instanceof BaseNode) {
                attributes.add((BaseNode) attrNode);
            }
        }

        List<ContentItemNode> content = new ArrayList<>();
        for (var item : ctx.contentItem()) {
            ASTNode node = visit(item);
            if (node instanceof ContentItemNode) {
                content.add((ContentItemNode) node);
            }
        }

        return new NormalElementNode(
                ctx.HTML_IDENTIFIER(0).getText(), // tagName
                attributes,
                content,
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        ) {
        };
    }

    @Override
    public ASTNode visitAttrTextNode(WebParser.AttrTextNodeContext ctx) {
        return new AttrTextNode(ctx.HTML_ATTR_VALUE_TEXT().getText(), ctx.start.getLine(), ctx.start.getCharPositionInLine()) {
        };
    }

    @Override
    public ASTNode visitDoubleQuotedValue(WebParser.DoubleQuotedValueContext ctx) {
        List<BaseNode> content = new ArrayList<>();
        for (var itemCtx : ctx.htmlAttrValueItem()) {
            ASTNode node = visit(itemCtx);
            if (node instanceof BaseNode) {
                content.add((BaseNode) node);
            }
        }
        return new DoubleQuotedValue(content, ctx.start.getLine(), ctx.start.getCharPositionInLine()) {
        };
    }

    @Override
    public ASTNode visitHtmlAttributeAssignment(WebParser.HtmlAttributeAssignmentContext ctx) {
        BaseNode valueNode = (BaseNode) visit(ctx.htmlAttributeValue());
        return new HtmlAttributeAssignment(
                ctx.HTML_IDENTIFIER().getText(),
                valueNode,
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        ) {
        };
    }

    @Override
    public ASTNode visitHtmlAttributeBoolean(WebParser.HtmlAttributeBooleanContext ctx) {
        return new HtmlAttributeBoolean(
                ctx.HTML_IDENTIFIER().getText(),
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        ) {
        };
    }

    @Override
    public ASTNode visitAttrDoubleQuoted(WebParser.AttrDoubleQuotedContext ctx) {
        return visit(ctx.dqValue());
    }

    @Override
    public ASTNode visitAttrSingleQuoted(WebParser.AttrSingleQuotedContext ctx) {
        return visit(ctx.sqValue());
    }


    @Override
    public ASTNode visitSingleQuotedValue(WebParser.SingleQuotedValueContext ctx) {
        List<BaseNode> content = new ArrayList<>();

        for (var itemCtx : ctx.htmlAttrValueItem()) {
            ASTNode node = visit(itemCtx);
            if (node instanceof BaseNode) {
                content.add((BaseNode) node);
            }
        }

        return new SingleQuotedValue(content, ctx.start.getLine(), ctx.start.getCharPositionInLine()) {
        };
    }


    @Override
    public ASTNode visitAttrJinjaExpressionNode(WebParser.AttrJinjaExpressionNodeContext ctx) {
        ASTNode exprNode = visit(ctx.jinjaExpression());
        if (exprNode instanceof ast.web.jinja.JinjaExpressionNode) {
            return new AttrJinjaExpressionNode((ast.web.jinja.JinjaExpressionNode) exprNode,
                    ctx.start.getLine(),
                    ctx.start.getCharPositionInLine()) {
            };
        }
        return null;
    }

    @Override
    public ASTNode visitAttrJinjaBlockNode(WebParser.AttrJinjaBlockNodeContext ctx) {
        ASTNode blockNode = visit(ctx.jinjaBlock());
        if (blockNode instanceof ast.web.jinja.JinjaBlockNode) {
            return new AttrJinjaBlockNode((ast.web.jinja.JinjaBlockNode) blockNode,
                    ctx.start.getLine(),
                    ctx.start.getCharPositionInLine()) {
            };
        }
        return null;
    }

    @Override
    public ASTNode visitAttrJinjaCommentNode(WebParser.AttrJinjaCommentNodeContext ctx) {
        ASTNode commentNode = visit(ctx.jinjaComment());
        if (commentNode instanceof ast.web.jinja.JinjaCommentNode) {
            return new AttrJinjaCommentNode((ast.web.jinja.JinjaCommentNode) commentNode,
                    ctx.start.getLine(),
                    ctx.start.getCharPositionInLine()) {
            };
        }
        return null;
    }

    @Override
    public ASTNode visitHtmlTextNode(WebParser.HtmlTextNodeContext ctx) {
        return new HtmlTextNode(ctx.TEXT().getText(),
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()) {
        };
    }

    @Override
    public ASTNode visitJinjaExprBodyNode(WebParser.JinjaExprBodyNodeContext ctx) {
        StringBuilder expr = new StringBuilder();
        for (var token : ctx.children) {
            expr.append(token.getText());
        }

        return new JinjaExprBodyNode(expr.toString(), ctx.start.getLine(), ctx.start.getCharPositionInLine()) {
        };
    }

    @Override
    public ASTNode visitJinjaExpressionNode(WebParser.JinjaExpressionNodeContext ctx) {
        ASTNode bodyNode = visit(ctx.jinjaExprBody());
        if (bodyNode instanceof JinjaExprBodyNode) {
            return new JinjaExpressionNode((JinjaExprBodyNode) bodyNode, ctx.start.getLine(), ctx.start.getCharPositionInLine());
        }
        return null;
    }


    @Override
    public ASTNode visitBlockElseNode(WebParser.BlockElseNodeContext ctx) {
        return new ElsePartNode(ctx.start.getLine(), ctx.start.getCharPositionInLine()) {
        };
    }

    @Override
    public ASTNode visitBlockEndIfNode(WebParser.BlockEndIfNodeContext ctx) {
        return new EndIfPartNode(ctx.start.getLine(), ctx.start.getCharPositionInLine()) {
        };
    }


    @Override
    public ASTNode visitBlockForEndNode(WebParser.BlockForEndNodeContext ctx) {
        return new ForEndNode(ctx.start.getLine(), ctx.start.getCharPositionInLine()) {
        };
    }

    @Override
    public ASTNode visitBlockIfStartNode(WebParser.BlockIfStartNodeContext ctx) {

        WebParser.IfStartContext ifCtx = ctx.ifStart();

        return new IfStartNode(
                ifCtx.getText().substring(2).trim(), // بعد if
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }


    @Override
    public ASTNode visitBlockElifNode(WebParser.BlockElifNodeContext ctx) {
        StringBuilder conditionBuilder = new StringBuilder();

        for (var child : ctx.children) {
            if (child instanceof WebParser.JinjaBlockExprContext) {
                if (!conditionBuilder.isEmpty()) {
                    conditionBuilder.append(" ");
                }
                conditionBuilder.append(child.getText());
            }
        }

        String condition = conditionBuilder.toString();
        return new ElifPartNode(condition, ctx.start.getLine(), ctx.start.getCharPositionInLine()) {
        };
    }

    @Override
    public ASTNode visitElifPartNode(WebParser.ElifPartNodeContext ctx) {
        String condition = ctx.children.stream()
                .filter(c -> c instanceof WebParser.JinjaBlockExprContext)
                .map(c -> c.getText()).reduce("", String::concat);

        return new ElifPartNode(condition,
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()) {
        };
    }

    @Override
    public ASTNode visitElsePartNode(WebParser.ElsePartNodeContext ctx) {
        return new ElsePartNode(ctx.start.getLine(), ctx.start.getCharPositionInLine()) {
        };
    }

    @Override
    public ASTNode visitEndIfPartNode(WebParser.EndIfPartNodeContext ctx) {
        return new EndIfPartNode(ctx.start.getLine(), ctx.start.getCharPositionInLine()) {
        };
    }


    @Override
    public ASTNode visitJinjaBlockNode(WebParser.JinjaBlockNodeContext ctx) {
        ASTNode inner = visit(ctx.jinjaBlockInner());

        if (inner == null) return null;

        if (inner instanceof BaseNode base) {
            return new JinjaBlockNode(
                    base,
                    ctx.start.getLine(),
                    ctx.start.getCharPositionInLine()
            );
        }

        throw new RuntimeException(
                "Invalid Jinja block content: " + inner.getClass()
        );
    }

    @Override
    public ASTNode visitForEndNode(WebParser.ForEndNodeContext ctx) {
        return new ForEndNode(ctx.start.getLine(), ctx.start.getCharPositionInLine()) {
        };
    }

    @Override
    public ASTNode visitJinjaCommentNode(WebParser.JinjaCommentNodeContext ctx) {
        String comment = ctx.JINJA_COMMENT_TEXT() != null ? ctx.JINJA_COMMENT_TEXT().getText() : "";
        return new JinjaCommentNode(comment, ctx.start.getLine(), ctx.start.getCharPositionInLine()) {
        };
    }

    @Override
    public ASTNode visitJinjaBlockExprNode(WebParser.JinjaBlockExprNodeContext ctx) {
        List<String> parts = new ArrayList<>();
        for (var child : ctx.children) {
            parts.add(child.getText());
        }
        return new JinjaBlockExprNode(parts, ctx.start.getLine(), ctx.start.getCharPositionInLine());
    }

    @Override
    public ASTNode visitSimpleStmtNode(WebParser.SimpleStmtNodeContext ctx) {
        StringBuilder statementBuilder = new StringBuilder();

        for (int i = 0; i < ctx.getChildCount(); i++) {
            String text = ctx.getChild(i).getText();

            if (!statementBuilder.isEmpty() && !text.isBlank()) {
                statementBuilder.append(" ");
            }
            statementBuilder.append(text);
        }
        String statement = statementBuilder.toString().trim();

        if (statement.isEmpty()) {
            return null;
        }
        return new WebSimpleStmtNode(
                statement,
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }


    @Override
    public ASTNode visitSetStmtNode(WebParser.SetStmtNodeContext ctx) {
        String assignment = ctx.jinjaBlockExpr().stream()
                .map(c -> c.getText())
                .reduce("", String::concat);

        return new SetStmtNode(assignment, ctx.start.getLine(), ctx.start.getCharPositionInLine()) {
        };
    }

    @Override
    public ASTNode visitBlockSetNode(WebParser.BlockSetNodeContext ctx) {
        String assignment = ctx.children.stream()
                .filter(c -> c instanceof WebParser.JinjaBlockExprContext)
                .map(c -> c.getText())
                .reduce("", String::concat);

        return new SetStmtNode(assignment, ctx.start.getLine(), ctx.start.getCharPositionInLine()) {
        };
    }

    @Override
    public ASTNode visitCssStyleNode(WebParser.CssStyleNodeContext ctx) {
        System.out.println("CSS STYLE VISITED");

        ASTNode rulesNode = visit(ctx.cssRules());
        if (rulesNode instanceof CssBodyNode body) {
            return new CssStyleNode(body, ctx.start.getLine(), ctx.start.getCharPositionInLine());
        }
        return null;
    }

    @Override
    public ASTNode visitCssRuleNode(WebParser.CssRuleNodeContext ctx) {
        ASTNode selectorListNode = visit(ctx.cssSelectorList());
        ASTNode declarationsNode = visit(ctx.cssDeclarations());

        if (selectorListNode instanceof CssSelectorListNode selectors &&
                declarationsNode instanceof CssBodyNode declarations) {
            return new CssRuleNode(selectors, declarations, ctx.start.getLine(), ctx.start.getCharPositionInLine());
        }
        return null;
    }

    @Override
    public ASTNode visitCssSelectorListNode(WebParser.CssSelectorListNodeContext ctx) {
        List<CssSelectorNode> selectors = new ArrayList<>();
        for (var child : ctx.cssSelector()) {
            ASTNode node = visit(child);
            if (node instanceof CssSelectorNode sel) {
                selectors.add(sel);
            }
        }
        return new CssSelectorListNode(selectors, ctx.start.getLine(), ctx.start.getCharPositionInLine());
    }

    @Override
    public ASTNode visitCssSelectorNode(WebParser.CssSelectorNodeContext ctx) {
        List<ASTNode> parts = new ArrayList<>();
        for (var partCtx : ctx.selectorPart()) {
            ASTNode node = visit(partCtx);
            if (node != null) {
                parts.add(node);
            }
        }
        return new CssSelectorNode(parts, ctx.start.getLine(), ctx.start.getCharPositionInLine());
    }

    @Override
    public ASTNode visitSelectorPartNode(WebParser.SelectorPartNodeContext ctx) {

        List<BaseNode> simpleSelectors = new ArrayList<>();

        for (var child : ctx.simpleSelector()) {
            ASTNode node = visit(child);

            if (node instanceof BaseNode baseNode) {
                simpleSelectors.add(baseNode);
            }
        }

        return new SelectorPartNode(
                simpleSelectors,
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }


    @Override
    public ASTNode visitTypeSelectorNode(WebParser.TypeSelectorNodeContext ctx) {
        return new TypeSelectorNode(ctx.getText(), ctx.start.getLine(), ctx.start.getCharPositionInLine());
    }

    @Override
    public ASTNode visitClassSelectorNode(WebParser.ClassSelectorNodeContext ctx) {
        return new ClassSelectorNode(ctx.getText(), ctx.start.getLine(), ctx.start.getCharPositionInLine());
    }

    @Override
    public ASTNode visitIdSelectorNode(WebParser.IdSelectorNodeContext ctx) {
        return new IdSelectorNode(ctx.getText(), ctx.start.getLine(), ctx.start.getCharPositionInLine());
    }

    @Override
    public ASTNode visitPseudoSelectorNode(WebParser.PseudoSelectorNodeContext ctx) {
        return new PseudoSelectorNode(ctx.getText(), ctx.start.getLine(), ctx.start.getCharPositionInLine());
    }

    @Override
    public ASTNode visitAttributeSelectorNode(WebParser.AttributeSelectorNodeContext ctx) {
        return new AttributeSelectorNode(
                ctx.CSS_IDENT(0).getText(), // attribute name
                ctx.getChildCount() > 4 ? ctx.getChild(3).getText() : null, // value (CSS_STRING or CSS_IDENT)
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }

    @Override
    public ASTNode visitCssDeclarationsNode(WebParser.CssDeclarationsNodeContext ctx) {
        List<CssDeclarationNode> declarations = new ArrayList<>();
        for (var declCtx : ctx.cssDeclaration()) {
            ASTNode node = visit(declCtx);
            if (node instanceof CssDeclarationNode decl) {
                declarations.add(decl);
            }
        }
        return new CssBodyNode(declarations, ctx.start.getLine(), ctx.start.getCharPositionInLine());
    }

    @Override
    public ASTNode visitCssDeclarationNode(WebParser.CssDeclarationNodeContext ctx) {
        String property = ctx.CSS_IDENT().getText();
        ASTNode valueNode = visit(ctx.cssValue());
        return new CssDeclarationNode(property, valueNode, ctx.start.getLine(), ctx.start.getCharPositionInLine());
    }
    @Override
    public ASTNode visitCssValueNode(WebParser.CssValueNodeContext ctx) {

        List<BaseNode> atoms = new ArrayList<>();

        for (var atomCtx : ctx.cssValueAtom()) {
            ASTNode node = visit(atomCtx);
            if (node instanceof BaseNode baseNode) {
                atoms.add(baseNode);
            }
        }

        return new CssValueNode(
                atoms,
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
    }

    @Override
    public ASTNode visitContentCssStyle(WebParser.ContentCssStyleContext ctx) {
        // كل ContentCssStyle يحتوي على CssStyleNode
        System.out.println("CONTENT CSS");

        ASTNode node = visit(ctx.cssStyleBlock());
        if (node instanceof CssStyleNode cssStyle) {
            return new ContentCssStyle(cssStyle, ctx.start.getLine(), ctx.start.getCharPositionInLine());
        }
        return null;
    }
    @Override
    public ASTNode visitCssRulesNode(WebParser.CssRulesNodeContext ctx) {
        List<CssRuleNode> rules = new ArrayList<>();
        for (var child : ctx.cssRule()) {
            ASTNode node = visit(child);
            if (node instanceof CssRuleNode rule) {
                rules.add(rule);
            }
        }
        return new CssBodyNode(rules, ctx.start.getLine(), ctx.start.getCharPositionInLine());
    }
    @Override
    public ASTNode visitAttributeSeNode(WebParser.AttributeSeNodeContext ctx) {
        // افترض أنه يمثل AttributeSelector مع ID
        String attrName = ctx.getChild(0).getText();
        String attrValue = ctx.children.size() > 1 ? ctx.getChild(1).getText() : null;
        return new AttributeSelectorNode(attrName, attrValue, ctx.start.getLine(), ctx.start.getCharPositionInLine());
    }
    @Override
    public ASTNode visitTypeSelectorIdNode(WebParser.TypeSelectorIdNodeContext ctx) {
        return new TypeSelectorNode(ctx.CSS_IDENT().getText(), ctx.start.getLine(), ctx.start.getCharPositionInLine());
    }
    @Override
    public ASTNode visitClassSelectorIdNode(WebParser.ClassSelectorIdNodeContext ctx) {
        return new ClassSelectorNode(ctx.CSS_IDENT().getText(), ctx.start.getLine(), ctx.start.getCharPositionInLine());
    }
    @Override
    public ASTNode visitIdSelectorIdNode(WebParser.IdSelectorIdNodeContext ctx) {
        return new IdSelectorNode(ctx.CSS_IDENT().getText(), ctx.start.getLine(), ctx.start.getCharPositionInLine());
    }
    @Override
    public ASTNode visitPseudoSelectorIdNode(WebParser.PseudoSelectorIdNodeContext ctx) {
        return new PseudoSelectorNode(ctx.CSS_IDENT().getText(), ctx.start.getLine(), ctx.start.getCharPositionInLine());
    }
    @Override
    public ASTNode visitCssValueAtom(WebParser.CssValueAtomContext ctx) {
        // قيمة فردية في CSS (مثل #FFF, 10px, 'hello')
        return new CssValueAtomNode(ctx.getText(), ctx.start.getLine(), ctx.start.getCharPositionInLine());
    }

}
