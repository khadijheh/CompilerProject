
## Compiler Project – Web-Based Language Analyzer

### 📖 Overview
This project is an educational application developed as part of the Compiler 1 course in the fourth year of the Software Engineering program. 
It implements a simplified Compiler within a web-based environment, aiming to bridge theoretical compiler concepts with practical implementation by analyzing a custom language that combines:
* Python (with Flask)
* HTML
* CSS
* Jinja2 Templates

The project covers all core compilation stages:
**Lexical Analysis → Parsing → AST → Symbol Table**,
and presents the results clearly through a web application interface.

---

### 🎯 Project Goals

* Perform lexical and syntactic analysis using a **Lexer & Parser**
* Build an **Abstract Syntax Tree (AST)** to represent the hierarchical structure of the source code
* Construct a **Symbol Table** to manage symbols such as variables, functions, and classes
* Support multiple languages within a single file (Python + Web Templates)
* Provide clear outputs (printed AST + Symbol Table)
* Apply **Object-Oriented Programming (OOP)** principles and the **Visitor Pattern** to ensure a flexible and extensible design

---

### 🧠 Core Concepts Implemented

* **Lexical Analysis**: Converts source code into a stream of tokens
* **Syntax Analysis**: Verifies the grammatical correctness of the code
* **Abstract Syntax Tree (AST)**: Structured internal representation of the program
* **Symbol Table**: Tracks symbols and their scopes
* **Visitor Pattern**: Enables operations such as AST printing and symbol table construction without modifying AST node structures

---

### 🛠️ Technologies Used

#### Backend / Compiler

* **Java**
* **ANTLR** (Lexer & Parser generation)
* **Visitor Pattern**
* **Object-Oriented Programming (OOP)**

#### Web Application

* **Flask** (Backend framework)
* **Jinja2** (Dynamic templating)
* **HTML & CSS** (User Interface)

---

### 🔍 Lexical Analysis

Multiple lexers were implemented to support different file types:

#### PythonLexer

* Handles indentation (Indent / Dedent)
* Processes newlines and Python keywords

#### WebCombinedLexer

* Analyzes files containing HTML, CSS, and Jinja
* Uses **Multiple Modes** to distinguish between different content types

The output of this stage is a stream of **Tokens** ready for the Parser.

---

### 🧩 Parsing & AST

Clear grammar rules were designed for:

* Python + Flask
* HTML
* CSS
* Jinja Expressions & Blocks

Each grammar rule is mapped to a corresponding **AST Node**.
Every node stores information such as:

* Node type
* Node name
* Line number and position

---

### 🌳 AST Structure

* All nodes implement the `ASTNode` interface
* The `accept(visitor)` method is used to support the Visitor Pattern
* Two main visitors are implemented:

  * **PythonVisitor** → for Python/Flask analysis
  * **WebVisitor** → for HTML/CSS/Jinja analysis

---

### 🖨️ AST Printing

* The AST is printed in a clear hierarchical format
* Indentation represents parent–child relationships
* Each node displays:

  * Its type
  * Its location in the source file

This greatly simplifies debugging and understanding the code structure.

---

### 📦 Symbol Table

* Built using the **Visitor Pattern**
* Supports:

  * Variables
  * Functions
  * Classes
  * Imports
  * Decorators
  * Web-related elements
* Handles nested scopes
* Displayed in two formats:

  * **Hierarchical View**
  * **Flat Table View**

---

### 🧪 Test Files

The project uses **three main test files** representing a simple web application:

* Product listing page
* Add product page
* Product details page (name, image, price, with delete option)

For each file, the system generates:

* The corresponding AST
* The resulting Symbol Table

---

### ▶️ Program Execution

* The `Main` class serves as the entry point
* It performs the following steps:

  1. Run the Lexer & Parser
  2. Generate the AST
  3. Print the AST
  4. Build and display the Symbol Table
* Supports both **Python files** and **Web Template files**

---
