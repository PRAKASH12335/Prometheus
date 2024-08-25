// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        // Press Opt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
            String s1 = "aab";
            String s2 = "cca";
            char[] count1 = new char[26];
            char[] count2 = new char[26];
            for(int i=0;i<s1.length();i++){
                count1[s1.charAt(i)-'a']++;
            }
            for(int i=0;i<s2.length();i++){
                count2[s2.charAt(i)-'a']++;
            }

            StringBuilder front = new StringBuilder();
            StringBuilder back = new StringBuilder();
            StringBuilder mid = new StringBuilder();
            for(int i=0;i<26;i++){
                int curr = (char)(i+'a');
                while(count1[i]>1){
                    front.append(curr);
                    back.insert(0, curr);
                    count1[i] -= 2;
                }
                while(count2[i]>1){
                    front.append(curr);
                    back.insert(0, curr);
                    count1[i] -= 2;
                }
                if(count1[i]== 1 && count2[i] == 1){
                    front.append(curr);
                    back.insert(0, curr);
                    count1[i] -= 1;
                    count2[i] -= 1;
                }
                if(count1[i]== 1 || count2[i] == 1){
                    mid.append(curr);
                }
            }
            String ans = front.toString()+mid.toString()+back.toString();
            System.out.println(ans);
        }
    }