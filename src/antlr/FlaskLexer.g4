lexer grammar FlaskLexer;

import CommonLexer;

// PYTHON/FLASK SPECIFIC TOKENS (محدث)
PYTHON_FLASK_IMPORT: 'from flask import' -> pushMode(PYTHON_MODE);
PYTHON_OS_IMPORT: 'import os' -> pushMode(PYTHON_MODE);
PYTHON_SQLALCHEMY_IMPORT: 'from flask_sqlalchemy import SQLAlchemy' -> pushMode(PYTHON_MODE);
PYTHON_FLASK_APP: '@app.route' -> pushMode(PYTHON_ROUTE_MODE);
PYTHON_CLASS_DEF: 'class' IDENTIFIER -> pushMode(PYTHON_CLASS_MODE);
PYTHON_DEF: 'def' IDENTIFIER -> pushMode(PYTHON_DEF_MODE);

// ===== PYTHON MODE =====
mode PYTHON_MODE;
    PYTHON_END: [;\n] -> popMode;

    // FLASK IMPORTS
    PYTHON_FLASK: 'Flask';
    PYTHON_RENDER_TEMPLATE: 'render_template';
    PYTHON_REQUEST: 'request';
    PYTHON_REDIRECT: 'redirect';
    PYTHON_URL_FOR: 'url_for';
    PYTHON_SESSION: 'session';
    PYTHON_FLASH: 'flash';

    // SQLALCHEMY
    PYTHON_SQLALCHEMY: 'SQLAlchemy';
    PYTHON_COLUMN: 'Column';
    PYTHON_STRING: 'String';
    PYTHON_INTEGER: 'Integer';
    PYTHON_FLOAT: 'Float';
    PYTHON_TEXT: 'Text';
    PYTHON_DATETIME: 'DateTime';
    PYTHON_PRIMARY_KEY: 'primary_key';

    // OS OPERATIONS
    PYTHON_OS: 'os';
    PYTHON_OS_PATH: 'os\\.path';
    PYTHON_OS_MKDIRS: 'os\\.makedirs';
    PYTHON_OS_EXISTS: 'os\\.path\\.exists';
    PYTHON_OS_JOIN: 'os\\.path\\.join';

    // DATABASE QUERIES (محدث)
    PYTHON_PRODUCT_QUERY: 'Product\\.query';
    PYTHON_FILTER_BY: 'filter_by';
    PYTHON_ORDER_BY: 'order_by';
    PYTHON_DESC: 'desc';
    PYTHON_ALL: 'all';
    PYTHON_FIRST: 'first';


    // REQUEST HANDLING (محدث)
    PYTHON_REQUEST_METHOD: 'request\\.method';
    PYTHON_REQUEST_FORM: 'request\\.form';
    PYTHON_REQUEST_FILES: 'request\\.files';

    // CONFIG
    PYTHON_CONFIG: 'config';
    PYTHON_UPLOAD_FOLDER: 'UPLOAD_FOLDER';
    PYTHON_SECRET_KEY: 'SECRET_KEY';
    PYTHON_SQLALCHEMY_DB_URI: 'SQLALCHEMY_DATABASE_URI';

    // PROJECT SPECIFIC VARIABLES (محدث)
    PYTHON_NEW_PRODUCT: 'new_product';
    PYTHON_PRODUCTS: 'products';
    PYTHON_PRODUCT: 'product';
    PYTHON_IMAGE_FILE: 'image_file';
    PYTHON_FILENAME: 'filename';
    PYTHON_IMAGE_PATH: 'image_path';

    PYTHON_WS: WS;

// ===== PYTHON ROUTE MODE =====
mode PYTHON_ROUTE_MODE;
    PYTHON_ROUTE_END: [)\n] -> popMode;
    PYTHON_ROUTE_PATH: STRING;
    PYTHON_METHODS: 'methods';
    PYTHON_GET: 'GET';
    PYTHON_POST: 'POST';
    PYTHON_DELETE: 'DELETE';

    PYTHON_ROUTE_WS: WS;

// ===== PYTHON CLASS MODE =====
mode PYTHON_CLASS_MODE;
    PYTHON_CLASS_END: [:\n] -> popMode;
    PYTHON_CLASS_NAME: IDENTIFIER;
    PYTHON_INHERITS: '(' IDENTIFIER ')';
    PYTHON_CLASS_WS: WS;

// ===== PYTHON DEF MODE =====
mode PYTHON_DEF_MODE;
    PYTHON_DEF_END: [:\n] -> popMode;
    PYTHON_FUNC_NAME: IDENTIFIER;
    PYTHON_PARAMS: '(' .*? ')';
    PYTHON_DEF_WS: WS;


