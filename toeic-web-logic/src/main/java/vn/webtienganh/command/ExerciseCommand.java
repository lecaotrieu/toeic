package vn.webtienganh.command;

import vn.webtienganh.core.dto.ExerciseDTO;
import vn.webtienganh.core.web.command.AbstractCommand;

public class ExerciseCommand extends AbstractCommand<ExerciseDTO> {
    public ExerciseCommand() {
        this.pojo = new ExerciseDTO();
    }
}
