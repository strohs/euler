(ns euler.problem3)

;;;;  Largest Prime Factor
;; The prime factors of 13195 are 5, 7, 13 and 29.
;; What is the largest prime factor of the number 600851475143 ?

(defn prime? [n]
  (not-any? #(zero? (rem n %)) (range (Math/ceil (Math/sqrt n)) 1.0 -1)))

(defn prime-factors [number]
  (for [n (range number 2 -1)
        :when (and (prime? n) (zero? (rem number n)))]
    n))

(defn factors
  "Return a list of factors of N."
  ([n]
   (factors n 2 ()))
  ([n k acc]
   (if (= 1 n)
     acc
     (if (= 0 (rem n k))
       (recur (quot n k) k (cons k acc))
       (recur n (inc k) acc)))))