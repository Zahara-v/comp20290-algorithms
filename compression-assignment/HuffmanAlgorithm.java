import java.util.PriorityQueue;
import java.util.*;

    public class HuffmanAlgorithm{

        char chars[];
        int freq[];
        Node root;
        Map<Character,String> vector = new HashMap();
        Map<String,Character> decodedMap = new HashMap();

        HuffmanAlgorithm()  {
        }
        HuffmanAlgorithm(char chars[], int freq[]){
            this.chars = chars;
            this.freq = freq;
            root = null;
        }
    

        void getFrequencies(String file)throws java.io.FileNotFoundException {
            Scanner f = new Scanner(new java.io.File(file));
            Map<Character,Integer> fm = new HashMap();
            while(f.hasNextLine()){
                String data = f.nextLine();
                for(int i=0;i<data.length();i++){
                    if(!fm.containsKey(data.charAt(i))){
                        fm.put(data.charAt(i),0);
                    }
                    fm.put(data.charAt(i),fm.get(data.charAt(i))+1);
                }
            }
            Set<Character> keys = fm.keySet();
            int size = keys.size();
            chars = new char[size];
            freq = new int[size];
            int i=0;
            for(char x : keys){
                chars[i] = x;
                freq[i] = fm.get(chars[i]);
                i++;
            }
            System.out.println("Frequency counts:");
            for(i=0;i<chars.length;i++){
                System.out.println(chars[i]+" : "+freq[i]);
            }
        }

        void buildTree(String file)throws java.io.FileNotFoundException{
        
            getFrequencies(file);

            //HuffTree h = new HuffTree(chars,freq);
            PriorityQueue<Node> heap = new PriorityQueue();
            for(int i=0;i<chars.length;i++){
                heap.add(new Node(chars[i],freq[i]));
            }
            while(heap.size()!=1){
                Node left  = heap.remove();
                Node right = heap.remove();
                //System.out.println(left+" "+right);
                Node newNode = new Node(left.freq+right.freq);
                newNode.left = left;
                newNode.right = right;
                root = newNode;
                heap.add(newNode);
            }
            gen(root,"");
            System.out.println("HuffMan codes : "+vector);


        }

        String decode(String data){

            String gen = "";
            String ans = "";
            Node temp = root;
            for(int i=0;i<data.length();i++){
                if(temp.leaf){
                    ans = ans+ temp.ch+"";
                    temp = root;
                }
                if(data.charAt(i)=='0'){
                    temp = temp.left;
                }
                else{
                    temp = temp.right;
                }
            }

            return ans;
        }

        String encode(String data){
            String ans = "";
            for(int i=0;i<data.length();i++){
                ans = ans+vector.get(data.charAt(i));
            }
            return ans;
        }

        String decodeFile(String fl)throws java.io.FileNotFoundException   {
            Scanner f = new Scanner(fl);
            String ans = "";
            while(f.hasNextLine()){
                ans = ans+decode(f.nextLine())+"\n";
            }
            return ans;
        }

        String encodeFile(String file)throws java.io.FileNotFoundException   {
            Scanner f = new Scanner(new java.io.File(file));
            String ans = "";
            while(f.hasNextLine()){
                ans = ans+encode(f.nextLine())+"\n";
            }
            return ans;
        }

        void gen( Node node, String gen){
            if(node.leaf){
                node.encoded = gen;
                vector.put(node.ch,gen);
                return;
            }
            gen(node.left,gen+"0");
            gen(node.right,gen+"1");
        }

        void print(Node node){
            if(node.leaf){
                System.out.println(node);
                return;
            }
            print(node.left);
            print(node.right);
        }

        void traverseHuffmanTree() throws Exception{
            print(root);
        }
        public static void main(String args[])throws java.io.FileNotFoundException{
            String file = "/Users/zaharavazir/Desktop/sowpods.txt";
            HuffmanAlgorithm tree = new HuffmanAlgorithm();
            tree.buildTree(file);
            String encoded = tree.encodeFile(file);
            System.out.println("Encoded String "+encoded);
            String decoded = tree.decodeFile(encoded);
            System.out.println("Decoded String : \n"+decoded);

        }
    }
class Node implements Comparable<Node> {
    char ch;
    int freq;
    Node left, right;
    boolean leaf = false;
    String encoded = "";

    Node(int freq) {
        this.freq = freq;
        this.leaf = false;
    }

    Node(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
        this.leaf = true;
    }

    @Override
    public int compareTo(Node n) {
        return this.freq - n.freq;
    }

    @Override
    public String toString() {
        return "(" + ch + " " + freq + " " + encoded + ")";
    }
}
