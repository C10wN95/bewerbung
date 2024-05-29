package com.msy.bewerbung;

import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class Bewerbung {

	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int choice;
		int antwort;

		Mail mail = new Mail();

		AwsBasicCredentials awsCreds = AwsBasicCredentials.create("AKIAYS2NVYZ24FQVAOLF",
				"lFTFfYQzQhVHWeNH/orn84FTPl+7wChRu4+qq3+3");
		S3Client s3 = S3Client.builder().region(Region.EU_NORTH_1)
				.credentialsProvider(StaticCredentialsProvider.create(awsCreds)).build();

		System.out.println(
				"Vielen Dank, dass Sie sich die Zeit nehmen, meine Bewerbung anzuschauen.\n"
						+ "Ich freue mich, Ihnen meine Qualifikationen und Erfahrungen vorzustellen.\n"
						+ "Viel Spaß beim Durchsehen meiner Bewerbung! 😊");

		do {
			System.out.println("Wählen Sie eines der folgenden Punkte aus:\n" + "Geben Sie eine Zahl ein...\n" 
					+ "... 1: Über mich (In meinem Lebenslauf steht nur ein kleiner Teil davon)\n"
					+ "... 2: Deckblatt\n" + "... 3: Lebenslauf\n" + "... 4: Zeugnisse und Zertifikate\n"
					+ "... 5: Bewerbungsunterlagen herunterladen\n" + "... 6: Antworten");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Ich bin ein Studienaussteiger der Fakultät Informatik mit tiefgreifenden Java-Kenntnissen und einem soliden Grundverständnis in SQL. \n\n"
						+ "Meine Begeisterung für die IT und mein stetiger Wunsch, mich weiterzuentwickeln, motivieren mich, innovative Softwarelösungen zu erschaffen. \n"
						+ "Derzeit erweitere ich mein Fachwissen durch einen spezialisierten Kurs im Spring Framework, angeboten von LearnQuest auf Coursera, \n"
						+ "der meine Fähigkeiten in der Entwicklung von Java-basierten Microservices und modernen Webanwendungen vertieft.\n\n"
						+ "In meinem Programm habe ich verschiedene Technologien und APIs integriert. \n"
						+ "Ich nutze die AWS SDK für Java, um sicher und effizient mit Amazon S3 zu interagieren. Mithilfe der `AwsBasicCredentials` und `StaticCredentialsProvider` authentifiziere ich mich, \n"
						+ "und mit der `S3Client`-Klasse lade ich Dateien herunter. \n"
						+ "Für die Benutzerinteraktion und Dateiverwaltung verwende ich die `Desktop` API, die es ermöglicht, Dateien direkt auf dem lokalen System zu öffnen und E-Mails zu versenden. \n"
						+ "Zudem kommen Java NIO (`java.nio.file`) Klassen zum Einsatz, um Dateipfade zu handhaben und Dateien sicher zu kopieren.\n\n"
						+ "Ich weiß, mein Lebenslauf sieht seit meiner Hochschulreife nicht besonders hervorragend aus, \n"
						+ "deshalb möchte ich das somit beruflich ändern und ein neues Kapitel in meinem Leben beginnen. \n"
						+ "Ich bin zielstrebig und lernwillig und freue mich darauf, meine Kenntnisse und Fähigkeiten in einem professionellen Umfeld weiter auszubauen.\n\n"
						+ "Die Kosten einer unbesetzten Softwareentwickler-Stelle in Deutschland können im IT-Bereich durchschnittlich 29.000 Euro pro Monat betragen \n"
						+ "(Stepstone, t3n Digital Pioneers). Bitkom berichtet, dass IT-Stellen im Durchschnitt 7,7 Monate unbesetzt bleiben, \n"
						+ "was zu erheblichen Kosten durch Produktivitätsverluste führt (Bitkom).\n\n"
						+ "Mit mir gewinnt Ihr Unternehmen einen kreativen, teamfähigen und selbständigen Mitarbeiter. \n"
						+ "Frühester Start wäre ab sofort, bei einem Umzug wäre ich nach 2 Monaten, abgerundet auf Monatsanfang, startbereit. \n\n"
						+ "Stellen Sie sich vor, wie ich in Ihrem Team sofort einen positiven Einfluss ausübe und dazu beitrage, Ihre Projekte erfolgreich umzusetzen. \n"
						+ "Ihre Entscheidung, mich einzustellen, wird Ihnen nicht nur einen motivierten Mitarbeiter, sondern auch einen zuverlässigen und lernwilligen Partner bringen, \n"
						+ "der Ihre Unternehmensziele unterstützt und vorantreibt. \n"
						+ "Ich freue mich auf die Möglichkeit, Ihnen persönlich zu zeigen, warum ich der ideale Kandidat für diese Position bin.\n");
			    System.out.println("Betätigen Sie die Enter-Taste, um fortzufahren...");
			    scanner.nextLine();
			    scanner.nextLine();
				break;
			case 2:
				openFileFromS3(s3, "bewerbungsprogramm", "Sevban Yasti - Deckblatt.pdf");
				break;
			case 3:
				openFileFromS3(s3, "bewerbungsprogramm", "Sevban Yasti - Lebenslauf (Softwareentwickler).pdf");
				break;
			case 4:
				openFileFromS3(s3, "bewerbungsprogramm", "Sevban Yasti - (S) Zertifikat & Zeugnisse.pdf");
				break;
			case 5:
				downloadFileFromS3(s3, "bewerbungsprogramm", "Sevban Yasti - Deckblatt.pdf",
						"Sevban Yasti - Deckblatt.pdf");
				downloadFileFromS3(s3, "bewerbungsprogramm", "Sevban Yasti - Lebenslauf (Softwareentwickler).pdf",
						"Sevban Yasti - Lebenslauf(Softwareentwickler).pdf");
				downloadFileFromS3(s3, "bewerbungsprogramm", "Sevban Yasti - (S) Zertifikat & Zeugnisse.pdf",
						"Sevban Yasti - Zertifikate.pdf");
			    System.out.println();

				break;
			case 6:
				System.out.println("Ich freue mich sehr, dass Sie sich die Zeit nehmen, meine Bewerbung zu prüfen. 😊\n"
						+ "Ich habe Ihnen die Mühe erspart und bereits Antworten vorbereitet:\n"
						+ "Bitte drücken Sie die \"1\" für eine Zusage. Ihre positive Rückmeldung würde mich sehr motivieren und mir die Möglichkeit geben, \n"
						+ "meine Fähigkeiten in Ihrem großartigen Unternehmen einzubringen.\n"
						+ "Falls Sie sich dennoch für eine Absage entscheiden, drücken Sie bitte die \"2\". Ich würde mich über ein kurzes Feedback freuen, \n"
						+ "um mich weiter verbessern zu können.\n"
						+ "Sie können die vorgefertigten Antworten in Ihrer E-Mail-Anwendung nach Belieben ergänzen und ändern.");
				antwort = scanner.nextInt();
				if (antwort == 1) {
					mail.zusagen();
				} else {
					mail.absagen();
				}
				break;
			default:
				break;
			}

		} while (choice >= 1 && choice < 6);

		scanner.close();
		s3.close();
	}

	private static void openFileFromS3(S3Client s3, String bucketName, String key) throws Exception {
		File tempFile = File.createTempFile("s3file-", ".pdf");
		tempFile.deleteOnExit();

		GetObjectRequest request = GetObjectRequest.builder().bucket(bucketName).key(key).build();
		try (InputStream inputStream = s3.getObject(request);
				FileOutputStream outputStream = new FileOutputStream(tempFile)) {
			byte[] buffer = new byte[1024];
			int bytesRead;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}
		}

		if (Desktop.isDesktopSupported()) {
			Desktop.getDesktop().open(tempFile);
		} else {
			System.out.println("Öffnen nicht unterstützt. Datei gespeichert unter: " + tempFile.getAbsolutePath());
		}
	}

	private static void downloadFileFromS3(S3Client s3, String bucketName, String key, String fileName)
			throws Exception {
		Path downloadPath = Paths.get(System.getProperty("user.home"), "Downloads", fileName);

		GetObjectRequest request = GetObjectRequest.builder().bucket(bucketName).key(key).build();
		try (InputStream inputStream = s3.getObject(request)) {
			Files.copy(inputStream, downloadPath, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("Datei heruntergeladen: " + downloadPath.toAbsolutePath());
		}
	}
}
