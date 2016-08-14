(ns euler.problem14)

;;; Longest Collatz sequence

(defn collatz [n]
  (loop [ns (list n)]
    (if (<= (first ns) 1)
      ns
      (if (even? (first ns))
        (recur (conj ns (/ (first ns) 2)))
        (recur (conj ns (inc (* 3 (first ns)))))))))

(defn -main [max-n]
  (reduce (fn [col n]
            (let [cnt (count (collatz n))]
              (if (> cnt (first col))
                [cnt n]
                col)))
          [-1 -1] (range max-n 0 -1)))

(defn -main2 [max-n]
  (->>
    (for [n (range max-n 0 -1)
          :let [ctz (collatz n)
                c (count ctz)]]
      [c n])
    (sort-by first > )
    (first)))
