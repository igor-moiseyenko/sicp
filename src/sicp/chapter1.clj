(ns sicp.chapter1)

"Sum and squares"

(defn square [x] (* x x))

(defn sum-of-squares [x y] (+ (square x) (square y)))

(defn f [a] (sum-of-squares (+ a 1) (* a 2)))

"Newton method. Block structure."

(defn new-if
  "Usage of this function instead of the 'if' special form causes StackOverflow exception
  while calculating square root, because it requires evaluation both 'then-clause' and 'else-clause'
  parameters ('if' special form evaluates one of these parameters conditionally)."
  [predicate then-clause else-clause]
  (cond predicate then-clause
        :else else-clause))

(defn average [x y] (/ (+ x y) 2))

(defn sqrt [x]
  (letfn [(good-enough? [guess]
                        (< (Math/abs (- (square guess) x)) 0.001))
          (improve [guess]
                   (average guess (/ x guess)))
          (sqrt-iter [guess]
                     (if (good-enough? guess)
                       guess
                       (recur (improve guess))))]
    (sqrt-iter 1.0)))
