package br.edu.ifpb.kelvin.nfs;

import java.nio.file.*;

public class NioNFS {

    private static String WORKDIR = System.getProperty("user.home") + "/pdist";

    public String process(String message) {
        String[] command = ((String) message).split(" ");
        switch (command[0]) {
            case "touch" -> this.touch(command[1]);
            case "rm" -> this.rm(command[1]);
            case "ls" -> {
                return this.ls();
            }
            default -> {
                return "Command not found";
            }
        }
        return "";
    }

    private void touch(String path) {
        try {
            Files.createFile(Paths.get(WORKDIR, path));
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

    private void rm(String path) {
        try {
            Files.delete(Paths.get(WORKDIR, path));
        } catch (Exception e) {
            System.out.println("Error");
        }
    }


    private String ls() {
        try {
            String[] files = Files.list(Paths.get(WORKDIR))
                    .map(Path::toString)
                    .toArray(String[]::new);

            return String.join(" ", files);
        } catch (Exception e) {
            return "Error" + e.getMessage();
        }
    }
}