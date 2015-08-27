(ns euler.problem9)

;;; Special Pythagorean Triplet
;; A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
;; a^2 + b^2 = c^2
;; For example, 32 + 42 = 9 + 16 = 25 = 52.
;;
;; There exists exactly one Pythagorean triplet for which a + b + c = 1000.
;; Find the product abc.

(defn pythagorean? [a b c]
  (= (+ (* a a) (* b b))
     (* c c)))

(defn sum []
  (for [a (range 1 1001)
        b (range (inc a) 1001)
        :let [c (- 1000 (+ a b))]
        :when (= (+ a b c) 1000)]
    [a b c]))

(def s (sum))
(println s)
(filter (fn [[a b c]] (pythagorean? a b c)) s)