package com.qrcode.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.qrcode.domain.User;
import com.qrcode.helpers.ZXingHelper;
import com.qrcode.model.Message;
import com.qrcode.model.Product;
import com.qrcode.repository.UserRepository;
import com.qrcode.service.IMessageService;
import com.qrcode.service.IProductService;

@Controller
@RequestMapping("/")
public class HomeController {

	@Autowired
	private IProductService productService;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private IMessageService messageService;

//	@Value("${upload.path}")
//	private String fileUpload;

	/*
	 * @GetMapping("/home") public String home(Model model) { List<Phim> fimls =
	 * (List<Phim>) phimService.findAll(); model.addAttribute("products", fimls);
	 * return "listPhim"; }
	 */
	@GetMapping("/trangchu")
	public String trangchu(Model model) {
		model.addAttribute("message", new Message());
		return "trangchu";

	}

	@PostMapping("/trangchu/save")
	public String save(@Valid Message message, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "trangchu";
		}
		messageService.save(message);
		redirect.addFlashAttribute("dagui", "Cảm ơn bạn đã gửi tin nhắn cho chúng tôi, chúng tôi sẽ liên hệ bạn sớm nhất có thể !!");
		return "redirect:/trangchu";
	}

	@GetMapping("/home")
	public String home(Model model) {
		User user = userRepository.findByEmail(getPrincipal());
		List<Product> product = productService.findByUserId(user.getId());
		model.addAttribute("sanpham", product);
		return "/client/listProduct";
	}

	@GetMapping("/home/create")
	public String create(Model model) {
		model.addAttribute("sanpham", new Product());
		return "/client/addProduct";
	}

	@GetMapping("/home/{id}/edit")
	public String edit(@PathVariable String id, Model model) {
		model.addAttribute("sanpham", productService.getOne(id));
		return "/client/addProduct";
	}

	@PostMapping("/home/save")
	public String save(@ModelAttribute Product product, BindingResult result, @RequestParam("ngaysx") String ngaysx,
			@RequestParam("hsd") String hsd, RedirectAttributes redirect,HttpServletRequest request) {
		if (result.hasErrors()) {
			return "/client/addProduct";
		}
		/*
		 * Product product1 = new
		 * Product.ProductBuilder(product.getId()).tenSanPham(product.getTensanpham())
		 * .xuatXu(product.getXuatxu()).thuongHieu(product.getThuonghieu()).loaiSanPham(
		 * product.getLoaisanpham())
		 * .giaBan(product.getGiaban()).moTa(product.getMota()).hinhAnh1(product.
		 * getHinhanh1()) .hinhAnh2(product.getHinhanh2()).build();
		 */
		Product product1 = productService.getOne(product.getId());

		User user = userRepository.findByEmail(getPrincipal());
		product1.setUser(user);
		UUID uuid = UUID.randomUUID();
		String[] uuidArrStrings = uuid.toString().split("-");
		String maSpString = uuidArrStrings[0] + uuidArrStrings[1];
		if (product.getId().equals("")) {
			product1.setId(maSpString);
		}
		if (product.getImage1() != null && product.getImage2() != null ) {
//			MultipartFile img1 = product.getImage1();
//			MultipartFile img2 = product.getImage2();
//
//			String img1Name = img1.getOriginalFilename();
//			String img2Name = img2.getOriginalFilename();
//
//			try {
//				FileCopyUtils.copy(product.getHinhanh1().getBytes(), new File(this.fileUpload + img1Name));
//				FileCopyUtils.copy(product.getHinhanh2().getBytes(), new File(this.fileUpload + img2Name));
//
//				product1.setHinhanh1("/images/" + img1Name);
//				product1.setHinhanh2("/images/" + img2Name);
//
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
			try {
			product1.setHinhanh1(saveUploadedFiles(request,product.getImage1(),product));
			product1.setHinhanh2(saveUploadedFiles(request,product.getImage2(),product));
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		Date date1;
		if (!ngaysx.equals(""))
			try {
				date = formatter.parse(ngaysx);
				date1 = formatter.parse(hsd);
				product1.setNgaysanxuat(date);
				if(date.compareTo(date1) < 0) {
					product1.setHansudung(date1);
				}
				else {
					System.out.println("sai");
					redirect.addFlashAttribute("error1", "Hạn sử dụng phải lớn hơn ngày sản xuất");
					return "redirect:/home/"+product.getId()+"/edit";
				}
					
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				date = new Date();
				date1 = new Date();
			}
	
		/*
		 * if(date.compareTo(date1)<0) {
		 */
		
//		}
//		else
//		{
//			redirect.addFlashAttribute("error1", "Hạn sử dụng phải lớn hơn ngày sản xuất");
//			return "redirect:/addProduct";
//		}

		productService.save(product1);
		redirect.addFlashAttribute("success", "Saved sản phẩm successfully!");
		return "redirect:/home";
	}
	private String saveUploadedFiles(HttpServletRequest request, MultipartFile files, Product product) throws IOException {
        String UPLOAD_DIR = System.getProperty("user.dir") + "/src/main/resources/static/images";
        String uploadRootPath = request.getServletContext().getRealPath("images");

        System.out.println("uploadRootPath=" + uploadRootPath);
        File uploadRootDir = new File(uploadRootPath);
        File uploadDir = new File(UPLOAD_DIR);
        if (!uploadRootDir.exists()) {
            uploadRootDir.mkdirs();
        }
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

            // Tên file gốc tại Client.
            String name = files.getOriginalFilename();
            System.out.println("Client File Name = " + name);

            if (name != null && name.length() > 0) {
                try {
                    // Tạo file tại Server.
                    File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + name);

                    // Luồng ghi dữ liệu vào file trên Server.
                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                    stream.write(files.getBytes());
                    stream.close();

                    File localFile = new File(uploadDir.getAbsolutePath() + File.separator + name);
                    BufferedOutputStream streamLocal = new BufferedOutputStream(new FileOutputStream(localFile));
                    streamLocal.write(files.getBytes());
                    streamLocal.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
        }
        return name;
    }

	@RequestMapping(value = "home/{id}", method = RequestMethod.GET)
	public void qrcode(@PathVariable("id") String id, HttpServletResponse response) throws Exception {
		response.setContentType("image/png");
		OutputStream outputStream = response.getOutputStream();
		outputStream.write(ZXingHelper.getQRCodeImage(id, 200, 200));
		outputStream.flush();
		outputStream.close();
	}

	@GetMapping("home/{id}/delete")
	public String delete(@PathVariable String id, RedirectAttributes redirect) {
//		quocgia emp = quocgiaService.findOne(id);
		productService.remove(id);
		redirect.addFlashAttribute("success", "Deleted sản phẩm successfully!");
		return "redirect:/home";
	}

	private String getPrincipal() {
		String userNameString = null;
		Object printObject = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (printObject instanceof UserDetails) {
			userNameString = ((UserDetails) printObject).getUsername();
		} else {
			userNameString = printObject.toString();
		}
		return userNameString;
	}

}
