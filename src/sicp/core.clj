(ns sicp.core
  (:gen-class)
  (:require [sicp.chapter1 :as chapter1]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
  (prn (chapter1/sqrt 9)))
