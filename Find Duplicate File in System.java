/*
  
  Given a list of directory info including directory path, and all the files with contents in this directory, you need to find out all the groups of duplicate files in the file system in terms of their paths.

  A group of duplicate files consists of at least two files that have exactly the same content.

  A single directory info string in the input list has the following format:

  "root/d1/d2/.../dm f1.txt(f1_content) f2.txt(f2_content) ... fn.txt(fn_content)"

  It means there are n files (f1.txt, f2.txt ... fn.txt with content f1_content, f2_content ... fn_content, respectively) in directory root/d1/d2/.../dm. Note that n >= 1 and m >= 0. If m = 0, it means the directory is just the root directory.

  The output is a list of group of duplicate file paths. For each group, it contains all the file paths of the files that have the same content. A file path is a string that has the following format:

  "directory_path/file_name.txt"

  Example 1:
  Input:
  ["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"]
  Output:  
  [["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]
  
  Note:
  No order is required for the final output.
  You may assume the directory name, file name and file content only has letters and digits, and the length of file content is in the range of [1,50].
  The number of files given is in the range of [1,20000].
  You may assume no files or directories share the same name in the same directory.
  You may assume each given directory info represents a unique directory. Directory path and file info are separated by a single blank space.

*/

class Solution {
   public List<List<String>> findDuplicate(String[] paths) {
      List<List<String>> result = new ArrayList<List<String>>();
      Map<String, List<String>> map = new HashMap<String, List<String>>();

      for (String files: paths) {
          parseFileAndUpdateContent(files, map);
      }

      for (String content : map.keySet()) {
          List<String> group = map.get(content);
          if (group.size() != 1)
              result.add(group);
      }
      return result;
    }

    private void parseFileAndUpdateContent(String directory, Map<String, List<String>> map) {
      String[] files = directory.split(" ");
      String root = files[0];

      for (int i = 1; i < files.length; i++) {
          String fileName = getFileName(files[i]);
          String content = getContent(files[i]);

          if (map.containsKey(content)) {
              List<String> group = map.get(content);
              group.add(root + "/" + fileName);
          } else {
              List<String> group = new ArrayList<String>();
              group.add(root + "/" + fileName);
              map.put(content, group);
          }
      }
    }

    private String getFileName(String file) {
      int i = 0;
      for (;i < file.length() && file.charAt(i) != '('; i++) {
      }
      return file.substring(0, i);
    }

    private String getContent(String file) {
        int i = 0;
        for (;i < file.length() && file.charAt(i) != '('; i++) {
        }
        int j = i;
        for (;j < file.length() && file.charAt(j) != ')'; j++) {
        }
        return file.substring(i+1, j);
    }
}
