(defproject signster "1.0.0-SNAPSHOT"
  :description "Signster"
  :dependencies
    [[org.clojure/clojure "1.2.0"]
     [org.clojure/clojure-contrib "1.2.0"]
     [ring/ring-core "0.2.0"]
     [ring/ring-jetty-adapter "0.2.0"]
     [org.clojars.thnetos/opennlp-tools "1.4.3"]
     [hiccup "0.2.6"]
     [lein-daemon "0.2.1"]]
  :dev-dependencies
    [[ring/ring-devel "0.2.0"]
     [lein-run "1.0.0-SNAPSHOT"]
     [lein-daemon "0.2.1"]]
  :daemon { "signster" {:ns "signster.core"
                        :args []
                        :options {}}})
