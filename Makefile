JAVAC=javac
JAVA=java
SRC_DIR=src
TEST_DIR=test
BIN_DIR=bin
LIB_DIR=lib
CP=$(LIB_DIR)/*

MAIN_CLASS=src.Main

SOURCES=$(shell find $(SRC_DIR) -name "*.java")
TESTS=$(shell find $(TEST_DIR) -name "*.java")

all: build

build:
	@echo "Compilando..."
	@mkdir -p $(BIN_DIR)
	@$(JAVAC) -d $(BIN_DIR) -cp "$(CP)" $(SOURCES) $(TESTS)
	@echo "Compilación completada."

run: build
	@echo "Ejecutando aplicación..."
	@$(JAVA) -cp "$(BIN_DIR):$(CP)" $(MAIN_CLASS)

test: build
	@echo "Ejecutando pruebas JUnit..."
	@java -jar lib/junit-platform-console-standalone-1.9.3.jar \
		--class-path bin \
		--scan-class-path

clean:
	@echo "Eliminando archivos compilados..."
	@rm -rf $(BIN_DIR)
	@echo "Limpieza completa."
