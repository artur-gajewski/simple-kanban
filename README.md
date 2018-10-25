
# Simple Kanban

A simple Kanban board created with ClojureScript/Reagent.

![screenshot](screenshot.png)

### Prerequisites

* Java 11 JDK
* [Leiningen](http://leiningen.org/)

Install using Brew:

    $ brew tap caskroom/versions
    
    $ brew cask install java

    $ brew install clojure
    
    $ brew install leiningen

### Usage

To start this application, use either ways:

    $ yarn dev

This will open your browser to [http://localhost:3449](http://localhost:3449)

### Build

To create a production release build:

    $ yarn release

This will compile application to an optimized `app.js` file and copy `index.html` and all required files to `release` folder.

## About

The license is MIT.
