(ns triangles.core
  "Utilities for solving triangles using Law of Sines and Law of Cosines. Uses standard
  lowercase letters to refer to sides and uppercase to refer to angles.")

(defn bAc->a
  "side,angle,side -> side via. law of cosines."
  [b A c]
  (Math/sqrt (- (+ (Math/pow b 2)
                   (Math/pow c 2))
                (* 2 b c (Math/cos A)))))

(defn abc->ABC
  "side,side,side -> angle,angle,angle using Law of Cosines."
  [a b c]
  (let [C (Math/acos (/ (- (Math/pow c 2)
                           (Math/pow a 2)
                           (Math/pow b 2))
                        (- (* 2 a b))))
        B (Math/acos (/ (- (Math/pow b 2)
                           (Math/pow a 2)
                           (Math/pow c 2))
                        (- (* 2 a c))))
        A (- Math/PI (+ C B))]
    [A B C]))

(defn abc->A [a b c]
  (nth (abc->ABC a b c) 0))

(defn abc->B [a b c]
  (nth (abc->ABC a b c) 1))

(defn abc->C [a b c]
  (nth (abc->ABC a b c) 2))

(defn abA->B [a b A]
  (Math/asin (/ (* b (Math/sin A)) a)))
