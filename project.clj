(defproject kanban "0.1.0-SNAPSHOT"
  :description "Simple Kanban"
  :url "http://github.com/artur-gajewski/simple-kanban"
  :license {:name "MIT"
            :url "https://opensource.org/licenses/MIT"}

  :dependencies [[org.clojure/clojure "1.8.0" :scope "provided"]
                 [org.clojure/clojurescript "1.9.562" :scope "provided"]
                 [javax.xml.bind/jaxb-api "2.3.0"]
                 [reagent "0.6.1"]]

  :plugins [[lein-cljsbuild "1.1.5"]
            [lein-figwheel "0.5.9"]]

  :min-lein-version "2.5.0"

  :clean-targets ^{:protect false}
  [:target-path
   [:cljsbuild :builds :app :compiler :output-dir]
   [:cljsbuild :builds :app :compiler :output-to]]

  :resource-paths ["public"]

  :figwheel {:http-server-root "."
             :nrepl-port 7002
             :nrepl-middleware ["cemerick.piggieback/wrap-cljs-repl"]
             :css-dirs ["public/css"]}

  :cljsbuild {:builds {:app
                       {:source-paths ["src" "env/dev/cljs"]
                        :compiler
                        {:main "simple-kanban.dev"
                         :output-to "public/js/app.js"
                         :output-dir "public/js/out"
                         :asset-path   "js/out"
                         :source-map true
                         :optimizations :none
                         :pretty-print  true}
                        :figwheel
                        {:open-urls ["http://localhost:3449/index.html"]}}
                      
                       :production
                       {:source-paths ["src" "env/prod/cljs"]
                        :compiler {:output-to "release/public/js/app.js"
                                   :optimizations :advanced
                                   :pretty-print false}}}}
  
  :aliases {"release" ["do" "clean" ["cljsbuild" "once" "production"]]}

  :profiles {:dev {:dependencies [[figwheel-sidecar "0.5.9"]
                                  [org.clojure/tools.nrepl "0.2.12"]
                                  [com.cemerick/piggieback "0.2.2-SNAPSHOT"]]}})
