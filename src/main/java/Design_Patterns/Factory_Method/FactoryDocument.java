package Design_Patterns.Factory_Method;

interface Document {
    void renderDocument();
}

class PDFDocument implements Document {
    public void renderDocument() {
        System.out.println("PDF Rendering..");
    }
}

class WordDocument implements Document {
    public void renderDocument() {
        System.out.println("Word Rendering..");
    }
}

class DocumentFactory {
    public Document createDocument(String documentType) {
        if(documentType.equals("PDF")) {
            return new PDFDocument();
        } else if (documentType.equals("Word")) {
            return new WordDocument();
        } else
            throw new IllegalArgumentException("Not good: " + documentType);
    }
}

class Main {
    public static void main(String[] args) {
        DocumentFactory factory = new DocumentFactory();
        Document first = factory.createDocument("PDF");
        first.renderDocument();

        Document second = factory.createDocument("Word");
        second.renderDocument();
    }
}