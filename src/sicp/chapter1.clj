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

"Recursion and iteration. Tree recursion."

"Factorial."

(defn factorial
  [n]
  (cond (<= n 1) 1
        :else (* n (factorial (- n 1)))))

(defn factorial-iteration
  [n]
  (letfn [(fact-iter
            [product count]
            (cond (> count n) product
                  :else (recur (* product count) (inc count))))]
    (fact-iter 1 1)))

"Fibonacci."

(defn fibonacci
  [n]
  (cond (<= n 0) 0
        (= n 1) 1
        :else (+ (fibonacci (- n 1)) (fibonacci (- n 2)))))

(defn fibonacci-iteration
  [n]
  (letfn [(fib-iter
            [a b count]
            (cond (>= count n) a
                  :else (recur (+ a b) a (inc count))))]
    (fib-iter 0 1 0)))

"Count change."

(defn first-denomination
  [kinds-of-coins]
  (cond (= kinds-of-coins 1) 1
        (= kinds-of-coins 2) 5
        (= kinds-of-coins 3) 10
        (= kinds-of-coins 4) 25
        (= kinds-of-coins 5) 50))

(defn cc
  [amount kinds-of-coins]
  (cond (= amount 0) 1
        (or (< amount 0) (= kinds-of-coins 0)) 0
        :else (+ (cc amount (- kinds-of-coins 1))
                 (cc (- amount (first-denomination kinds-of-coins)) kinds-of-coins))))

(defn count-change
  [amount]
  (cc amount 5))

"Fast exponent evaluation."

(defn fast-expt
  [a n]
  (cond (= n 0) 1
        (even? n) (square (fast-expt a (/ n 2)))
        :else (* a (fast-expt a (- n 1)))))


"Half-interval method."

(defn close-enough?
  [x y]
  (< (Math/abs (- x y)) 0.001))

(defn search
  [f neg-point pos-point]
  (let [mid-point (average neg-point pos-point)]
    (if (close-enough? neg-point pos-point)
      mid-point
      (let [test-value (f mid-point)]
        (cond (pos? test-value) (search f neg-point mid-point)
              (neg? test-value) (search f mid-point pos-point)
              :else mid-point)))))

(defn half-interval-method
  [f a b]
  (let [a-value (f a)
        b-value (f b)]
    (cond (and (neg? a-value) (pos? b-value)) (search f a b)
          (and (neg? b-value) (pos? a-value)) (search f b a)
          :else (prn "Error! Function values for arguments have the same sign."))))

