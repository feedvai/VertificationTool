(declare-fun flag_0 () Int)
(declare-fun n_0 () Int)
(declare-fun k_0 () Int)
(declare-fun k_1 () Int)
(declare-fun i_0 () Int)
(declare-fun i_1 () Int)
(declare-fun i_2 () Int)
(declare-fun i_3 () Int)
(declare-fun i_4 () Int)
(declare-fun i_5 () Int)
(declare-fun j_0 () Int)
(declare-fun j_1 () Int)
(declare-fun j_2 () Int)
(declare-fun j_3 () Int)
(declare-fun j_4 () Int)
(declare-fun j_5 () Int)
(declare-fun z_0 () Int)
(declare-fun return () Int)
(assert (= k_0 1))
(assert (and (=> (> flag_0 0) (= k_1 (* n_0 n_0))) (=> (not (> flag_0 0)) (= k_1 k_0))))
(assert (= i_0 0))
(assert (= j_0 0))
(assert (and (=> (<= i_0 n_0) (and (and (= i_1 (+ i_0 1)) (= j_1 (+ j_0 i_1))) (and (=> (<= i_1 n_0) (and (and (= i_2 (+ i_1 1)) (= j_2 (+ j_1 i_2))) (and (=> (<= i_2 n_0) (and (and (= i_3 (+ i_2 1)) (= j_3 (+ j_2 i_3))) (and (=> (<= i_3 n_0) (and (and (= i_4 (+ i_3 1)) (= j_4 (+ j_3 i_4))) (and (=> (<= i_4 n_0) (and (= i_5 (+ i_4 1)) (= j_5 (+ j_4 i_5)))) (=> (not (<= i_4 n_0)) (and (= i_5 i_4) (= j_5 j_4)))))) (=> (not (<= i_3 n_0)) (and (= i_5 i_3) (= j_5 j_3)))))) (=> (not (<= i_2 n_0)) (and (= i_5 i_2) (= j_5 j_2)))))) (=> (not (<= i_1 n_0)) (and (= i_5 i_1) (= j_5 j_1)))))) (=> (not (<= i_0 n_0)) (and (= i_5 i_0) (= j_5 j_0)))))
(assert (= z_0 (+ (+ k_1 i_5) j_5)))
(assert (= return z_0))
(assert (not (= return 0)))
(check-sat)
(get-model)