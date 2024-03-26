package com.rays.ctl;

import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.AttachmentDTO;
import com.rays.dto.BookDTO;
import com.rays.form.bookForm;
import com.rays.service.AttachmentServiceInt;
import com.rays.service.BookServiceInt;

@RestController
@RequestMapping(value = "User")
public class BookCtl extends BaseCtl<bookForm, BookDTO, BookServiceInt> {

	@Autowired
	public BookServiceInt userService;

	@Autowired
	public AttachmentServiceInt attachmentService;

	@PostMapping("profilePic/{userId}")
	public ORSResponse uploadPic(@PathVariable Long userId, @RequestParam("file") MultipartFile file,
			HttpServletRequest req) {

		BookDTO userDTO = userService.findById(userId);
		AttachmentDTO attachmentDto = new AttachmentDTO(file);

		attachmentDto.setDescription("profile pic");

		attachmentDto.setUserId(userId);

		if (userDTO.getImageId() != null && userDTO.getImageId() > 0) {

			attachmentDto.setId(userDTO.getImageId());
		}

		Long imageId = attachmentService.add(attachmentDto);

		if (userDTO.getImageId() == null) {
			userDTO.setImageId(imageId);
			userService.update(userDTO);

		}

		ORSResponse res = new ORSResponse();
		res.addResult("imageId", imageId);

		return res;
	}
	
	@GetMapping("/profilePic/{userId}")
	public @ResponseBody void downloadPic(@PathVariable Long userId, HttpServletResponse response) {
		
		
		try{ 
			BookDTO userDTO = userService.findById(userId);
		
		AttachmentDTO attachmentDTO = null;
		
		if (userDTO != null) {
			
			attachmentDTO = attachmentService.findById(userDTO.getImageId());
			
			
		
		}
		if (attachmentDTO != null) {
			
			response.setContentType(attachmentDTO.getType());
			
			OutputStream out = response.getOutputStream();
			
			out.write(attachmentDTO.getDoc());
			out.close();
		} else {
         
			response.getWriter().write("ERROR: File not found");
		}
		
		
		}catch (Exception e) {
			e.printStackTrace();
		
		
		}
}
	}