# Find in Bytes

This repository is an example of how to search for text within bytes using Oracle/Oracle Text functions using Java with
Spring.

## Technologies Used

- Java 8
- Oracle database

## Motivation

I received an interesting challenge and decided to create this repository in response to it. The proposed challenge was
as follows:

1. The user can upload files with the following extensions: csv, pdf, txt, doc, docx, xls, xlsx, xml.
2. The user can download any uploaded file.
3. It should be possible to search for keywords within the files and return the snippet where they are found.

## Constraints

The API must be built using Java with Spring and connect to the Oracle database. It is not allowed to use search or
analysis mechanisms such as Elasticsearch, etc.

## Getting Started

We started with the basic functionality of receiving the file from the user and saving it in the database as a BLOB,
allowing for later download. This way, it is not necessary to keep the file in a separate directory.

## Data Model

The Document table is used to store the files and has the following initial columns:

- **ID** - automatically generated identifier.
- **NAME** - full name of the file.
- **FILE** - file bytes.
- **CONTENT** - file content.

To make the functionality of searching, a database function called "getSnippetOfContent" was created. This function uses
Oracle functions such as DBMS_LOB.SUBSTR and DBMS_LOB.INSTR to find the desired text snippet.

## API Documentation

The API documentation can be accessed at: http://localhost:8080/swagger-ui/index.html

**Note:** Make sure the application is running to access the API documentation.