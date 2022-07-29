class Solution {
    public String reverseWords(String s) {
	
        String[] str = s.trim().split("\\s+"); //remove extra spaces and convert string into string array
        
		StringBuilder sb = new StringBuilder();
		sb.append(str[str.length-1]);
		//start from end
		for(int i = str.length - 2; i >= 0; i--){
		sb.append(" "+str[i]);
		}
		return sb.toString();
       
    }
}