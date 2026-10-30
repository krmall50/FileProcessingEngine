# File Processing Engine

A Java console application that scans a directory, processes multiple text files concurrently, analyzes their contents, and generates statistical reports.

## Features

- **File scanning:** Automatically discovers files in the `input/` directory and accepts `.txt` files.
- **Concurrent processing:** Uses `ExecutorService` with a fixed thread pool to process files concurrently.
- **Word counting:** Calculates the total number of words in each file.
- **Unique word counting:** Counts unique words separately for each file and across all processed files.
- **Line counting:** Calculates the number of lines in each file.
- **Word frequency analysis:** Identifies the four most frequently occurring words across all scanned files (or fewer if there are fewer unique words).
- **File comparison:** Identifies the file containing the most words.
- **Report generation:** Saves a report containing individual file statistics and combined statistics in the `output/` directory.

## Technologies and Concepts

- Java
- Java Collections Framework (`ArrayList`, `HashMap`)
- Stream API (`filter`, `map`, `distinct`, `sorted`, `count`)
- Lambda expressions and method references
- `ExecutorService` and thread pools
- `Callable` and `Future`
- Exception handling
- File I/O
- `Comparable` and sorting

## Project Structure

```text
FileProcessingEngine/
├── src/
│   ├── Main.java
│   ├── App.java
│   ├── FileScannerTxt.java
│   ├── FileProcesser.java
│   ├── FileStatistics.java
│   ├── ProcessingService.java
│   ├── ReportGenerator.java
│   └── Scannable.java
├── input/
│   └── .gitkeep
├── output/
│   └── .gitkeep
├── bin/
└── .gitignore
```

## How to Run

### Requirements

- Java 21 or later
- Git (optional)

### 1. Clone the repository

```bash
git clone <repository-url>
cd FileProcessingEngine
```

### 2. Add input files

Place your `.txt` files inside the `input/` directory.

### 3. Compile the project

```bash
javac -d bin src/*.java
```

### 4. Run the application

```bash
java -cp bin Main
```

### 5. View the report

After processing, the generated report will be saved in:

```text
output/
```

Each report includes a timestamp in its filename.

## Example Report

```text
========== PROCESSING REPORT ==========

Files discovered: 3
Files processed successfully: 3
Files failed: 0

TOTAL STATISTICS
Lines: 25
Words: 150
Unique Words: 87

MOST FREQUENT WORDS
java: 12
data: 8
streams: 6
threads: 5

FILE STATISTICS
example1.txt
  Lines: 10
  Words: 60
  Unique words: 42

example2.txt
  Lines: 15
  Words: 90
  Unique words: 55

File with most words: example2.txt
```

*The example values are illustrative.*

## Notes

- Only `.txt` files are supported.
- Files with unsupported formats are skipped.
- Words are converted to lowercase for case-insensitive counting.
- Punctuation is excluded from word counting, with apostrophes retained.
- The application uses two worker threads for concurrent file processing.
- Input files and generated reports are excluded from version control.