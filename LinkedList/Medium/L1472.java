package LinkedList.Medium;

// 1472. Design Browser History

public class L1472 {
    class Node{
        String pageName;
        Node next;
        Node prev;

        Node(String pageName){
            this.pageName = pageName;
        }
    }
    Node currPage;

    L1472(String homepage) {
        currPage = new Node(homepage);
    }

    public void visit(String url) {
        Node newPage = new Node(url);
        currPage.next = newPage;
        newPage.prev = currPage;
        currPage = newPage;
    }
    // Time Complexity - 0(1)

    public String back(int steps) {
        while(steps > 0){
            if(currPage.prev == null)
                break;
            else
                currPage = currPage.prev;
            steps--;
        }
        return currPage.pageName;
    }
    // Time Complexity - 0(steps)

    public String forward(int steps) {
        while(steps > 0){
            if(currPage.next == null)
                break;
            else
                currPage = currPage.next;
            steps--;
        }
        return currPage.pageName;
    }
    // Time Complexity - 0(steps)

    public static void main(String[] args) {
        L1472 browserHistory = new L1472("leetcode.com");
        browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
        browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
        browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
        browserHistory.back(1);                   // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
        browserHistory.back(1);                   // You are in "facebook.com", move back to "google.com" return "google.com"
        browserHistory.forward(1);                // You are in "google.com", move forward to "facebook.com" return "facebook.com"
        browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
        browserHistory.forward(2);                // You are in "linkedin.com", you cannot move forward any steps.
        browserHistory.back(2);                   // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
        browserHistory.back(7);                   // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"
    }
}


// Time Complexity - 0(N)