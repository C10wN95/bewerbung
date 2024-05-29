package com.msy.bewerbung;

import java.awt.Desktop;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Mail {
    private final String ablehnungBetreff = "Ihre Bewerbung: Leider keine Zusage";
    private final String zusageBetreff = "Ihre Bewerbung: Herzlichen Glückwunsch!";
    private final String ablehnungText = "Sehr geehrter Herr Yasti,\n\n"
            + "vielen Dank für Ihre Bewerbung und Ihr Interesse an der ausgeschriebenen Stelle. "
            + "Nach sorgfältiger Prüfung Ihrer Unterlagen müssen wir Ihnen leider mitteilen, dass wir Ihnen keine Zusage erteilen können.\n\n"
            + "Gründe für die Ablehnung:\n"
            + "- Grund\n"
            + "- Grund\n"
            + "- Grund\n\n"
            + "Wir wünschen Ihnen für Ihren weiteren beruflichen Werdegang alles Gute und viel Erfolg.\n\n"
            + "Mit freundlichen Grüßen,\n"
            + "[Ihr Unternehmen]";
    private final String zusageText = "Sehr geehrter Herr Yasti,\n\n"
            + "wir freuen uns, Ihnen mitteilen zu können, dass Sie die Stelle bekommen haben. "
            + "Herzlichen Glückwunsch! Wir sind beeindruckt von Ihren Qualifikationen und Erfahrungen und sind überzeugt, dass Sie eine wertvolle Bereicherung für unser Team sein werden.\n\n"
            + "Bitte lassen Sie uns wissen, wann Sie Ihren Arbeitsbeginn planen, damit wir die nächsten Schritte einleiten können.\n\n"
            + "Mit freundlichen Grüßen,\n"
            + "[Ihr Unternehmen]";
    public void zusagen() {
        sendMail(zusageBetreff, zusageText);
    }

    public void absagen() {
        sendMail(ablehnungBetreff, ablehnungText);
    }

    private void sendMail(String subject, String body) {
        try {
            String mailto = String.format("mailto:m_sevban_95@hotmail.de?subject=%s&body=%s", 
                            encode(subject), encode(body));
            Desktop.getDesktop().mail(new URI(mailto));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String encode(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString()).replace("+", "%20");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
