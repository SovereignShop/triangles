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
  (Math/acos (/ (- (Math/pow a 2)
                   (Math/pow b 2)
                   (Math/pow c 2))
                (- (* 2 b c)))))

(defn abc->B [a b c]
  (Math/acos (/ (- (Math/pow b 2)
                   (Math/pow a 2)
                   (Math/pow c 2))
                (- (* 2 a c)))))

(defn abc->C [a b c]
  (Math/acos (/ (- (Math/pow c 2)
                   (Math/pow a 2)
                   (Math/pow b 2))
                (- (* 2 a b)))))

(defn abA->B [a b A]
  (Math/asin (/ (* b (Math/sin A)) a)))
