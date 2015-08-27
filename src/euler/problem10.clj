(ns euler.problem10)

;The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
;Find the sum of all the primes below two million.

(defn prime? [n]
  (cond
    (< n 2) false
    (= n 2) true
    :else
    (not-any? #(zero? (rem n %)) (range (Math/ceil (Math/sqrt n)) 1.0 -1))))

;;(reduce + (filter prime? (range 2 2000000)))
;; 142913828922  when starting at 2
