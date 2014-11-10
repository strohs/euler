(ns euler.problem4)

;;; A palindromic number reads the same both ways. The largest palindrome made from the product of
;;; two 2-digit numbers is 9009 = 91 × 99.
;;; Find the largest palindrome made from the product of two 3-digit numbers.

(defn palindrome? [n] (= (seq (str n)) (reverse (str n))))

(defn get-palindromes []
  (apply sorted-set
         (for [i (range 100 999)
               j (range 100 999)
               :let [n (* i j)]
               :when (palindrome? n)]
           n)))
