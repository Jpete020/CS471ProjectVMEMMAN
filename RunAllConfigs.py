import os

os.remove("output.txt")
for pageSize in (512, 1024, 2048):
    for frameCount in (4, 8, 12):
        os.system(f"java -jar build/libs/CS471ProjectVMEMMAN-1.0-SNAPSHOT.jar input.txt {pageSize} {frameCount} >> output.txt")
