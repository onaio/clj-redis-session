(defproject clj-redis-session-onaio "2.1.3-SNAPSHOT"
  :url "https://github.com/onaio/clj-redis-session"
  :description "Redis-backed Clojure/Ring session store"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [ring/ring-core "1.6.0-beta6"]
                 [com.taoensso/carmine "2.15.0"]]
  :profiles {
    :uber {
      :aot :all}
    :1.5 {
      :dependencies [
        [org.clojure/clojure "1.5.0"]
        [medley "0.6.0" :exclusions [org.clojure/clojure]]]}
    :1.6 {
      :dependencies [
        [org.clojure/clojure "1.6.0"]
        [medley "0.6.0" :exclusions [org.clojure/clojure]]]}
    :1.7 {
      :dependencies [[org.clojure/clojure "1.7.0"]]}
    :1.8 {
      :dependencies [[org.clojure/clojure "1.8.0"]]}
    :1.9 {
      :dependencies [[org.clojure/clojure "1.9.0-alpha14"]]}})
