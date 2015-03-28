(defproject kata-potter "0.0.1"
            :description "Kata Potter"
            :dependencies [[org.clojure/clojure "1.6.0"]
                           [org.clojure/math.combinatorics "0.1.1"]]
            :profiles {:dev {:dependencies [[midje "1.6.3"]]
                             :plugins      [[lein-midje "3.1.3"]]}})

