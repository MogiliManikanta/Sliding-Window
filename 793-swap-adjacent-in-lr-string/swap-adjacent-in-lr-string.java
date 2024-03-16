class Solution {
    public boolean canTransform(String start, String end) {
    if(start.length() != end.length()) return false;

    //check for string without X, it should be the same
    String startStr = start.replace("X", "");
    String endStr = end.replace("X", "");

    if(!(startStr.equals(endStr)) ) return false;
    List<Integer> startL = new ArrayList<>();
    List<Integer> startR = new ArrayList<>();
    List<Integer> endL = new ArrayList<>();
    List<Integer> endR = new ArrayList<>();


    for(int i=0; i<start.length(); i++){
        if(start.charAt(i) == 'L')
            startL.add(i);
        else if(start.charAt(i) == 'R')
            startR.add(i);
    }

    for(int i=0; i<end.length(); i++){
        if(end.charAt(i) == 'L')
            endL.add(i);
        else if(end.charAt(i) == 'R')
            endR.add(i);
    }

    // check L positions are correct
    for(int i=0; i<startL.size(); i++){
        if(startL.get(i) < endL.get(i))
            return false;
    }

    // check R positions are correct
    for(int i=0; i<startR.size(); i++){
        if(startR.get(i) > endR.get(i))
            return false;
    }

    return true;
    }
}