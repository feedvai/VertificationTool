(declare-fun IN_0 () Real)
(declare-fun x_0 () Real)
(declare-fun result_0 () Real)
(declare-fun return () Real)
(assert (= x_0 IN_0))
(assert (= result_0 (+ (+ (- x_0 (/ (* (* x_0 x_0) x_0) 6)) (/ (* (* (* (* x_0 x_0) x_0) x_0) x_0) 120)) (/ (* (* (* (* (* (* x_0 x_0) x_0) x_0) x_0) x_0) x_0) 5040))))
(assert (= return result_0))
(assert (and (> (+ IN_0 1.57079632679) 0) (< IN_0 1.57079632679)))
(assert (not (and (<= return 1.01) (>= (+ return 1.01) 0))))
(check-sat)
(get-model)