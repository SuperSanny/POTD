//Leetcode : https://leetcode.com/problems/maximize-the-confusion-of-an-exam/
public class MaximizetheConfusionofanExam {
    public static int maxConsecutiveAnswers(String answerKey, int k) {
        int ans = 0, maxf = 0, count[] = new int[128];
        for (int i = 0; i < answerKey.length(); ++i) {
            maxf = Math.max(maxf, ++count[answerKey.charAt(i)]);
            if (ans - maxf < k)
                ans++;
            else
                count[answerKey.charAt(i - ans)]--;
        }
        return ans;
    }
    public static void main(String[] args) {
        int k = 2;
        String answerkey = "TTFF";
        int answer = maxConsecutiveAnswers(answerkey, k);
        System.out.println(answer);

    }
}
