package vn.webtienganh.command;

import vn.webtienganh.core.dto.ExaminationDTO;
import vn.webtienganh.core.web.command.AbstractCommand;

/**
 * Created by Admin on 3/12/2017.
 */
public class ExaminationCommand extends AbstractCommand<ExaminationDTO> {
	public ExaminationCommand() {
		this.pojo = new ExaminationDTO();
	}
}
