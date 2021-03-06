package edu.umass.problems;
import edu.umass.data.list.List;
import edu.umass.data.tuple.Pair;
import edu.umass.data.Unit;
import edu.umass.problems.helper.HowMany;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Optional;

/**
 * This is a rough take on the 99 Haskell Problems (and 99 Prolog Problems
 * (and 99 Lisp Problems)). The point of these is to work <em>functionally</em>
 * and no imperative features should be used. This includes
 *
 * <ul>
 *     <li>Any mutation of state</li>
 *     <li>Any loops (while/for/for-each)</li>
 *     <li>Any impure functions (i.e./ with side effects)</li>
 * </ul>
 *
 */

public class Problems99 {
    /* Questions 1 - 10: Basic Lists */
    /**
     * Problem 1: findLast. Given a {@code List<T>} return the last * element
     * wrapped in a {@code Just} or {@code Nothing} if the list is empty.
     *
     * Example: {@code findLast([1,2,3,4]) -> Just(4)}
     * Example: {@code findLast([]) -> Nothing}
     *
     * @param ts List of type {@code T}
     * @param <T>
     * @return last element in the list wrapped in {@code Just} if it exists;
     *         otherwise return {@code Nothing}
     */
    public <T> Optional<T> findLast(List<T> ts){
        throw new NotImplementedException();
    }

    /**
     * Problem 2: findButLast. Given a {@code List<T> ts} return the
     * second to last element wrapped in a {@Code Just} if it exists; otherwise
     * return a {@code Nothing}.
     *
     * Example: {@code findButLast([1,2,3,4]) -> Just(3)}
     * Example: {@code findButLast([1]) -> Nothing}
     * @param ts
     * @param <T>
     * @return second to last element in the list wrapped in {@code Just} if it
     *         exists; otherwise return {@code Nothing}
     */
    public <T> Optional<T> findButLast(List<T> ts){
        throw new NotImplementedException();
    }

    /**
     * Problem 3: elementAt. Return the kth element of a list
     *
     * Example: {@code elementAt([1,2,3,4,5], 3) -> Just(3)}
     * Example: {@code elementAt([1,2,3,4,5], 6) -> Nothing}
     *
     * @param ts List to extract kth element from
     * @param k element number to extract
     * @param <T>
     * @return Return the kth element of {@code ts} wrapped in a {@code Just}
     *         if it exists; other wise return {@code Nothing}
     */
    public <T> Optional<T> elementAt(List<T> ts, int k){
        throw new NotImplementedException();
    }

    /**
     * Problem 4: length. Return the length of the list
     *
     * Example: {@code length([1,2,3,4]) -> 4}
     * Example: {@code length([]) -> 0}
     *
     * @param ts list to measure
     * @param <T>
     * @return number of elements in ts
     */
    public <T> int length(List<T> ts){
        throw new NotImplementedException();
    }

    /**
     * Problem 5: reverseList. Given a list ts, return a list that is the
     * reverse of ts.
     *
     * Example: {@code reverseList([1,2,3,4]) -> [4,3,2,1]}
     * Example: {@code reverseList([]) -> []}
     *
     * @param ts list to reverse
     * @param <T>
     * @return ts reversed
     */
    public <T> List<T> reverseList(List<T> ts){
        throw new NotImplementedException();
    }

    /**
     * Problem 6: isPalindrome. Return true precisely when ts reads the same
     * forwards and backwards.
     *
     * Example: {@code isPalindrome([1,2,3,4]) -> false}
     * Example: {@code isPalindrome([1,2,3,4,3,2,1]) -> true}
     *
     * @param ts List to test for property of being a palindrome
     * @param <T>
     * @return true iff ts is a palindrome
     */
    public<T> boolean isPalindrome(List<T> ts) {
        throw new NotImplementedException();
    }

    /**
     * Problem 7: flattenList. Given a list of lists of type T, return a list
     * of type T by replacing each list with its elements (preserving order
     * in each list).
     *
     * Example: {@code flattenList([ [1,2,3], [4,5,6]]) -> [1,2,3,4,5,6]}
     * Example: {@code flattenList([[1],[2],[3,4],[5,6,7]]) -> [1,2,3,4,5,6,7]}
     *
     * @param ts List of lists to flatten
     * @param <T>
     * @return Flattened list
     */
    public<T> List<T> flattenList(List<List<T>> ts){
        throw new NotImplementedException();
    }

    /**
     * Problem 8: compress. Given a list of T, compress it so that each element
     * in the returned list distinct from its neighbors; remove consecutive
     * repetitions of elements in the list.
     *
     * Example: {@code compress([1,1,2,2,3,2,1]) -> [1,2,3,2,1]}
     * Example: {@code compress([1,2,3,2,3,2,1]) -> [1,2,3,2,3,2,1]}
     *
     * @param ts list to compress
     * @param <T>
     * @return the compressed list
     */
    public<T> List<T> compress(List<T> ts){
        throw new NotImplementedException();

    }

    /**
     * Problem 9: packConsecutive. Given a list of type T, pack consecutive
     * identical elements into a sublist.
     *
     * Example: {@code packConsecutive([1,1,2,3,3,4,3]) -> [[1,1],[2],[3,3],[4],[5]]}
     * Example: {@code packConsecutive([1,1,1,1]) ->[[1,1,1,1]]}
     *
     * @param ts list to pack
     * @param <T>
     * @return packed list
     */
    public<T> List<List<T>> packConsecutive(List<T> ts){
        throw new NotImplementedException();
    }

    /**
     * Problem 10: encode. Given a list of type T, represent each run of n
     * consecutive elements {@code e} that are identical (n >= 1) as a tuple
     * {@code Pair<T,Integer>(e, n)}.
     *
     * Example: {@code encode([1,1,2,2,2,3]) -> [Pair(1,2), Pair(2,3), Pair(3,1)]}
     * @param ts List to encode
     * @param <T>
     * @return Encoded list
     */
    public<T> List<Pair<T,Integer>> encode(List<T> ts){
        throw new NotImplementedException();
    }

    /* Questions 11 - 20: Intermediate Lists */

    /**
     * Problem 11: encodeModified. Given a list of type T, do as for encode
     * (problem 10) but use the Single and Multiple classes instead (these
     * are defined in edu.umass.problems.helper and extend the HowMany class
     * defined in the same directory).
     *
     * Example: {@code encodeModified([1,1,2,3]) -> [Multiple(1,2), Single(2), Single(3)]}
     *
     * @param ts
     * @param <T>
     * @return
     */
    public<T> List<HowMany<T>> encodeModified(List<T> ts){
        throw new NotImplementedException();
    }

    /**
     * Problem 12: decodeModified. Given a list of {@code HowMany<T>}, return a
     * list of type {@code T} such that encodeModified(decodeModified(ts)) = ts.
     *
     * Example: {@code decodeModified([Single('a'), Multiple('b', 3)]) -> ['a','b','b','b']}
     *
     * @param ts
     * @param <T>
     * @return
     */
    public <T> List<T> decodeModified(List<HowMany<T>> ts){
        throw new NotImplementedException();
    }

    // TODO: Problem 13

    /**
     * Problem 14: dupli. Duplicate the elements of the list
     *
     * Example: {@code dupli([1,2,3]) -> [1,1,2,2,3,3]}
     *
     * @param ts list to duplicate
     * @param <T>
     * @return doubled list
     */
    public<T> List<T> dupli(List<T> ts){
        throw new NotImplementedException();
    }


    /**
     * Problem 15: repli. Replicate the elements of a list a given number of times.
     *
     * Example: {@code repli([1,2,3], 3) => [1,1,1,2,2,2,3,3,3]}
     *
     * @param ts
     * @param n
     * @param <T>
     * @return
     */
    public<T> List<T> repli(List<T> ts, int n){
        throw new NotImplementedException();
    }

    /**
     * Problem 16: dropEveryN.
     * @param ts
     * @param n
     * @param <T>
     * @return
     */
    public<T> List<T> dropEveryN(List<T> ts, int n){
        throw new NotImplementedException();
    }

    /**
     * Problem 17: splitAtN.
     * @param ts
     * @param n
     * @param <T>
     * @return
     */
    public <T> Pair<List<T>, List<T>> splitAtN(List<T> ts, int n){
        throw new NotImplementedException();
    }

    /**
     * Problem 18: slice.
     * @param ts
     * @param lo
     * @param hi
     * @param <T>
     * @return
     */
    public<T> List<T> slice(List<T> ts, int lo, int hi){
        throw new NotImplementedException();
    }

    /**
     * Problem 19: rotate.
     * @param ts
     * @param n
     * @param <T>
     * @return
     */
    public<T> List<T> rotate(List<T> ts, int n){
        throw new NotImplementedException();
    }

    /**
     * Problem 20: removeAt.
     * @param xs
     * @param n
     * @param <T>
     * @return
     */
    public<T> List<T> removeAt(List<T> xs, int n){
        throw new NotImplementedException();
    }

    /* Questions 21 - 28: Advanced Lists */

    /**
     * Problem 21: insertAt.
     * @param xs
     * @param elem
     * @param pos
     * @param <T>
     * @return
     */
    public<T> List<T> insertAt(List<T> xs, T elem, int pos){
        throw new NotImplementedException();
    }

    /**
     * Problem 22: range.
     * @param lo
     * @param hi
     * @param <T>
     * @return
     */
    public<T> List<Integer> range(int lo, int hi){
        throw new NotImplementedException();
    }

    /**
     * Problem 23: rndSelect.
     * @param n
     * @param <T>
     * @return
     */
    public<T> List<T> rndSelect(List<T> ts, int n){
        throw new NotImplementedException();
    }

    /**
     * Problem 24: rndDraw.
     * @param ts
     * @param count
     * @param hi
     * @param <T>
     * @return
     */
    public<T> List<T> rndDraw(List<T> ts, int count, int hi){
        throw new NotImplementedException();
    }

    /**
     * Problem 25: rndPermutation.
     * @param ts
     * @param <T>
     * @return
     */
    public <T> List<T> rndPermutation(List<T> ts){
        throw new NotImplementedException();
    }

    /**
     * Problem 26: combinations.
     * @param ts
     * @param <T>
     * @return
     */
    public <T> List<T> combinations(List<T> ts){
        throw new NotImplementedException();
    }

    /**
     * Problem 27: multinomialGroupings.
     * @param groupSizes
     * @param elements
     * @param <T>
     * @return
     */
    public <T> List<T> multinomialGroupings(List<Integer> groupSizes, List<T> elements){
        throw new NotImplementedException();
    }

    /**
     * Problem 28: lengthSort
     * @param ts
     * @param <T>
     * @return
     */
    public<T> List<List<T>> lengthSort(List<List<T>> ts){
        throw new NotImplementedException();
    }

    /* Questions 31 - 41: Arithmetic */

    /**
     * Problem 31: isPrime.
     * Difficulty: **
     * @param n
     * @return
     */
    public boolean isPrime(int n){
        throw new NotImplementedException();
    }

    /**
     * Problem 32: gcd.
     * Difficulty: **
     * @param a
     * @param b
     * @return
     */
    public int gcd(int a, int b){
        throw new NotImplementedException();
    }


    /**
     * Problem 33: coprime
     * Difficulty: *
     * @param a
     * @param b
     * @return
     */
    public boolean coprime(int a, int b){
        throw new NotImplementedException();
    }

    /**
     * Problem 34: totient
     * Difficulty: **
     * @param n
     * @return
     */
    public int totient(int n){
        throw new NotImplementedException();
    }

    /**
     * Problem 35: primeFactors
     * Difficulty: **
     * @param n
     * @return
     */
    public List<Integer> primeFactors(int n){
        throw new NotImplementedException();
    }

    /**
     * Problem 36: primeFactorsMult
     * Difficulty: **
     * @param n
     * @return
     */
    public List<Pair<Integer, Integer>> primeFactorsMult(int n){
        throw new NotImplementedException();
    }

    // TODO: 37

    // TODO: 38

    /**
     * Problem 39: primesInRange
     * Difficulty: *
     * @param lo
     * @param hi
     * @return
     */
    public List<Integer> primesInRange(int lo, int hi){
        throw new NotImplementedException();
    }


    /**
     * Problem 40: goldbach.
     * Difficulty: **
     * @param n
     * @return
     */
    public Pair<Integer, Integer> goldbach(int n){
        throw new NotImplementedException();
    }

    /**
     * Problem 41: printEvenGoldbachs
     * Difficulty: **
     * @param lo
     * @param hi
     * @return
     */
    public Unit printEvenGoldbachs(int lo, int hi){
        throw new NotImplementedException();
    }
    /* Questions 46 - 50:  */
    /* Questions 51 - 60:  */
    /* Questions 61 - 70:  */
    /* Questions 71 - 60:  */
    /* Questions 81 - 70:  */
    /* Questions 91 - 99:  */

}
