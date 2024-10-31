package com.example.ScheduleMate.utils.converters;

import com.example.ScheduleMate.dto.PackageDto;
import com.example.ScheduleMate.entity.Packages;

import java.util.function.Function;

public class PackageDtoUtils {

    public static final Function<PackageDto, Packages> PACKAGE_DTO_PACKAGES_FUNCTION = packageDto -> {
        Packages packages = new Packages();
        packages.setId(packageDto.getId());
        packages.setName(packageDto.getName());
        packages.setDuration(packageDto.getDuration());
        packages.setMaximumCount(packageDto.getMaximumCount());
        packages.setPrice(packageDto.getPrice());
        return packages;
    };

    public static final Function<Packages, PackageDto> PACKAGES_PACKAGE_DTO_FUNCTION = packages -> {
        PackageDto packageDto = new PackageDto();
        packageDto.setId(packages.getId());
        packageDto.setName(packages.getName());
        packageDto.setDuration(packages.getDuration());
        packageDto.setMaximumCount(packages.getMaximumCount());
        packageDto.setPrice(packages.getPrice());
        return packageDto;
    };
}
