(ns euler.problem6)

;;; Sum of Square Difference

;; The sum of the squares of the first ten natural numbers is,
;; 1^2 + 2^2 + ... + 10^2 = 385
;;
;; The square of the sum of the first ten natural numbers is,
;; (1 + 2 + ... + 10)^2 = 55^2 = 3025
;;
;; Hence the difference between the sum of the squares of the first ten natural numbers and the square of the
;; sum is 3025 − 385 = 2640. Find the difference between the sum of the squares of the first one hundred natural
;; numbers and the square of the sum.

(defn sum-squares [a b] (apply +' (map #(.pow (biginteger %) 2) (range a (inc b)))))

(defn square-sum [a b] (.pow (biginteger (apply +' (range a (inc b)))) 2))

(- (sum-squares 1 100) (square-sum 1 100))
