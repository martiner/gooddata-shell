# GoodData Shell

[![Build Status](https://travis-ci.org/martiner/gooddata-shell.png?branch=master)](https://travis-ci.org/martiner/gooddata-shell)

The *GoodData Shell* is a command line client for interacting with the [GoodData Platform](http://www.gooddata.com/).
It is built on the [GoodData Java SDK](https://github.com/martiner/gooddata-java) and the [Spring Shell](http://docs.spring.io/spring-shell/docs/current/reference/html/).


## Features

* tab completions
* command history
* colorized output
* script execution (run with `--cmdfile file.txt` command line argument or use `script` command)

## Usage

1. [Download](https://github.com/martiner/gooddata-shell/releases)
2. Run `java -jar gooddata-shell-1.0-SNAPSHOT.jar`
3. Type `help` to get started

## Develop

1. `mvn verify`
2. `mvn exec:java`

### Update Driver
1. `mvn -f driver/pom.xml clean package`
1. commit new jar file
