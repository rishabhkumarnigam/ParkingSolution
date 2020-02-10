package dto;

public class InstructionDto {
    private String instructionType;
    private String instructionValue;


    public InstructionDto() {
    }

    public String getInstructionType() {
        return instructionType;
    }

    public void setInstructionType(String instructionType) {
        this.instructionType = instructionType;
    }

    public String getInstructionValue() {
        return instructionValue;
    }

    public void setInstructionValue(String instructionValue) {
        this.instructionValue = instructionValue;
    }
}
