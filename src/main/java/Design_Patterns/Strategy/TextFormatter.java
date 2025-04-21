package Design_Patterns.Strategy;

interface TextFormatter {
    String formatText(String text);
}

class UpperCaseFormatter implements TextFormatter {

    public String formatText(String text) {
        return text.toUpperCase();
    }
}

class LowerCaseFormatter implements TextFormatter {

    public String formatText(String text) {
        return text.toLowerCase();
    }
}

class CamelCaseFormatter implements TextFormatter {

    public String formatText(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }

        String[] words = text.split(" ");
        String finalWord = "";

        finalWord += words[0].toLowerCase();
        for(int i = 1; i < words.length; i++) {
            if(words[i].isEmpty()) continue;

            finalWord += words[i].substring(0,1).toUpperCase() + words[i].substring(1).toLowerCase();
        }
        return finalWord;
    }
}


class TextEditor {
    private TextFormatter textFormatter;

    public void setFormatter(TextFormatter textFormatter) {
        this.textFormatter = textFormatter;
    }

    public String formatText(String text) {
        return this.textFormatter.formatText(text);
    }
}

class Main03 {
    public static void main(String[] args) {
        TextEditor textEditor = new TextEditor();

        textEditor.setFormatter(new UpperCaseFormatter());
        System.out.println(textEditor.formatText("Hello World"));

        textEditor.setFormatter(new LowerCaseFormatter());
        System.out.println(textEditor.formatText("Hello WORLD"));

        textEditor.setFormatter(new CamelCaseFormatter());
        System.out.println(textEditor.formatText("HeLlOW oRlD"));
    }
}