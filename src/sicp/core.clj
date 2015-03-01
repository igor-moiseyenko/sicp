(ns sicp.core
  (:gen-class)
  (:require [sicp.chapter1 :as chapter1]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
  (prn (chapter1/sqrt 9))
  (prn (chapter1/new-if (= 1 1) 0 5))
  (prn (chapter1/factorial 7))
  (prn (chapter1/factorial-iteration 7))
  (prn (chapter1/fibonacci 10))
  (prn (chapter1/fibonacci-iteration 10))
  (prn (chapter1/count-change 100)))
