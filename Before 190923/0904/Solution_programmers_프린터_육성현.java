import java.util.LinkedList;
import java.util.List;

class Solution {
    class Document{
		int p;
		int i;
		public Document(int p, int i) {
			super();
			this.p = p;
			this.i = i;
		}
	}
	    public int solution(int[] priorities, int location) {
	    	List<Document> q = new LinkedList<>();
	    	for(int i=0;i<priorities.length;i++) {
	    		q.add(new Document(priorities[i],i));
	    	}
	        int answer = 0;
	        boolean vec;
	        while(true) {
	        	Document f = q.get(0);
	        	Document out = null;
	        	vec = false;
	        	for(int i=1;i<q.size();i++) {
	        		if(q.get(i).p>f.p) {
	        			q.remove(0);
	        			q.add(f);
	        			vec = true;
                        break;
	        		}
	        	}
	        	if(vec==false) {
                    answer++;
	        		q.remove(0);
	        		out = f;
                    if(out.i==location)
                        return answer;
	        	}
	        }
	    }
	}