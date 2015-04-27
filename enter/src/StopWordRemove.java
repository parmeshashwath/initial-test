import java.util.List;
public class StopWordRemove {
public static void stopwordRemove(List<String> wordList) {
/*String[] stopWordsofwordnet = { "without", "see", "unless", "due",
"also", "must", "might", "like", "will", "may", "can", "much",
"every", "the", "in", "other", "this", "the", "many", "any",
"an", "or", "for", "in", "an", "an", "is", "a", "about",
"couldn’t", "did", "didn’t", "do", "does", "doesn’t", "doing",
"don’t", "down", "during", "each", "few","of","are"};*/
	String[] stopWordsofwordnet = { "Please", "select","your","issue","issue/request","a","about","above","after","again","against","all","am","an","and","any","are","aren't","as","at","be","because","been","before","being","below","between","both","but","by","can't","cannot","could","couldn't","did","didn't","do","does","doesn't","doing","don't","down","during","each","few","for","from","further","had","hadn't","has","hasn't","have","haven't","having","he","he'd","he'll","he's","her","here","here's","hers","herself","him","himself","his","how","how's","i","i'd","i'll","i'm","i've","if","in","into","is","isn't","it","it's","its","itself","let's","me","more","most","mustn't","my","myself","no","nor","not","of","off","on","once","only","or","other","ought","our","ours",};

// remove stop words here from the temp list
for (int i = 0; i < wordList.size(); i++) {
// get the item as string
for (int j = 0; j < stopWordsofwordnet.length; j++) {
if (stopWordsofwordnet[j].contains(wordList.get(i))) {
wordList.remove(i);
i--;
break;
}
}
}
}
}