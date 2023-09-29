package br.edu.ifpb.kelvin.nfs;

import java.util.ArrayList;
import java.util.List;

public class NFS {

    private final List<String> files = new ArrayList<>();
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
        this.files.add(path);
    }

    private void rm(String path) {
        this.files.remove(path);
    }

    private String ls() {
        return String.join(" ", this.files);
    }
}
