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
  (prn (chapter1/count-change 100))
  (prn (chapter1/fast-expt 2 10))

  "Evaluate equation sin(x) = 0 on [2.0 4.0] interval."
  (prn (chapter1/half-interval-method #(Math/sin %) 2.0 4.0))

  "Evaluate equation x^3 - 2x - 3 = 0 on [1.0 2.0] interval."
  (prn (chapter1/half-interval-method #(- (Math/pow % 3) (* % 2) 3) 1.0 2.0))

  (prn (chapter1/fixed-point #(Math/cos %) 1.0))
  (prn (chapter1/fixed-point #(+ (Math/sin %) (Math/cos %)) 1.0))
  (prn (chapter1/sqrt-fixed-point 9)))
