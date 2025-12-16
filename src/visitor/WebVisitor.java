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
            if (node instanceof ContentItemNode) {
                contentNodes.add((ContentItemNode) node);
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
    public ASTNode visitCssDeclarationNode(WebParser.CssDeclarationNodeContext ctx) {
        String property = ctx.CSS_PROPERTY().getText();
        ASTNode valueNode = visit(ctx.CSS_VALUE()); // زيارة قيمة الـ CSS
        return new CssDeclarationNode(
                property,
                valueNode.toString(),
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine()
        );
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
        CssBodyNode body = (CssBodyNode) visit(ctx.cssBody());
        return new CssStyleNode(body, ctx.start.getLine(), ctx.start.getCharPositionInLine()) {
        };
    }

    @Override
    public ASTNode visitCssBodyNode(WebParser.CssBodyNodeContext ctx) {
        List<BaseNode> rules = new ArrayList<>();
        for (var rule : ctx.cssRule()) {
            ASTNode node = visit(rule);
            if (node instanceof BaseNode) {
                rules.add((BaseNode) node);
            }
        }
        return new CssBodyNode(rules, ctx.start.getLine(), ctx.start.getCharPositionInLine()) {
        };
    }

    @Override
    public ASTNode visitCssRuleNode(WebParser.CssRuleNodeContext ctx) {
        BaseNode selector = (BaseNode) visit(ctx.cssSelector());

        List<CssDeclarationNode> declarations = new ArrayList<>();
        for (var child : ctx.cssDeclarations().children) {
            ASTNode node = visit(child);
            if (node instanceof CssDeclarationNode) {
                declarations.add((CssDeclarationNode) node);
            }
        }

        return new CssRuleNode(selector, declarations, ctx.start.getLine(), ctx.start.getCharPositionInLine()) {
        };
    }

    @Override
    public ASTNode visitSelectorSimpleNode(WebParser.SelectorSimpleNodeContext ctx) {
        return new SelectorSimpleNode(ctx.getText(), ctx.start.getLine(), ctx.start.getCharPositionInLine()) {
        };
    }

    @Override
    public ASTNode visitSelectorClassNode(WebParser.SelectorClassNodeContext ctx) {
        return new SelectorClassNode(ctx.getText(), ctx.start.getLine(), ctx.start.getCharPositionInLine()) {
        };
    }

    @Override
    public ASTNode visitSelectorIdNode(WebParser.SelectorIdNodeContext ctx) {
        return new SelectorIdNode(ctx.getText(), ctx.start.getLine(), ctx.start.getCharPositionInLine()) {
        };
    }

    @Override
    public ASTNode visitSelectorPseudoNode(WebParser.SelectorPseudoNodeContext ctx) {
        String text = ctx.getText();
        String pseudoClass = text;
        String pseudoElement = null;
        if (text.contains("::")) {
            String[] parts = text.split("::", 2);
            pseudoClass = parts[0];
            pseudoElement = parts[1];
        }
        return new SelectorPseudoNode(pseudoClass, pseudoElement, ctx.start.getLine(), ctx.start.getCharPositionInLine()) {
        };
    }

    @Override
    public ASTNode visitCssDeclarationsNode(WebParser.CssDeclarationsNodeContext ctx) {
        List<CssDeclarationNode> declarations = new ArrayList<>();
        for (var child : ctx.children) {
            ASTNode node = visit(child);
            if (node instanceof CssDeclarationNode) {
                declarations.add((CssDeclarationNode) node);
            }
        }
        return new CssBodyNode(new ArrayList<>(declarations), ctx.start.getLine(), ctx.start.getCharPositionInLine()) {
        };
    }

}
