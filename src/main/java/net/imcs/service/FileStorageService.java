package net.imcs.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileStorageService {
	public abstract String storeFile(MultipartFile file);
	public abstract Resource loadFileAsResource(String fileName);
}
