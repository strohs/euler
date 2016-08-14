(ns euler.problem12)

;; infinite sequence of triangle numbers
(def triangles (map first (iterate (fn [[a b]] [(+' a b) (inc b)]) [1 2])))

(defn divisors
  "brute force function to find all divisors of n"
  [n]
  (filter #(= 0 (rem n %)) (range 1 (inc n))))

(defn factors
  "find all factors of n using the quicker n .. sqrt(n) heuristic"
  [n]
  (reduce (fn [sset num]
            (if (= 0 (rem n num))
              (conj sset num (int (/ n num)))
              sset))
          (sorted-set 1) (range n (dec (int (Math/sqrt n))) -1)))


(defn count-divisors [n]
  (let [sqrt (int (Math/sqrt n))
        nums (range 1 (inc sqrt))
        remainders (map #(rem n %) nums)
        divisor-count (* 2 (count (filter zero? remainders)))]
    (if (= n (* sqrt sqrt))
      (dec divisor-count)
      divisor-count)))

;(defn count-divisors [n]
;  (count (factors n)))



(defn -main [threshold]
  (->> triangles
       (remove #(< % threshold))
       (filter #(> (count-divisors %) threshold))
       (take 1)))