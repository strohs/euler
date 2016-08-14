(ns euler.problem13)

;;; large sum

(def numbers-file "src/euler/50digit-nums.txt")

(defn read-nums [f] (clojure.string/split-lines (slurp f)))

(defn -main []
  (->> (read-nums numbers-file)
       (map #(bigint %))
       (apply +')))


