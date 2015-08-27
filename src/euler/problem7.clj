(ns euler.problem7)

;;; By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
;;; What is the 10 001st prime number?

(defn prime? [n]
  (cond
    (< n 2) false
    (= n 2) true
    :else
    (not-any? #(zero? (rem n %)) (range (Math/ceil (Math/sqrt n)) 1.0 -1))))

(take 10 (filter #(prime? %) (range)))

